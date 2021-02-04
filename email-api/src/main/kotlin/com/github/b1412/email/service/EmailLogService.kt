package com.github.b1412.email.service

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService
import com.amazonaws.services.simpleemail.model.*
import com.amazonaws.services.simpleemail.model.Message
import com.amazonaws.services.sqs.AmazonSQS
import com.amazonaws.services.sqs.model.*
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.b1412.api.service.BaseService
import com.github.b1412.email.config.AmazonEmailProperties
import com.github.b1412.email.dao.EmailLogDao
import com.github.b1412.email.dao.EmailServerDao
import com.github.b1412.email.entity.EmailLog
import com.github.b1412.email.enum.TaskStatus
import com.github.b1412.extenstions.responseEntityOk
import com.github.b1412.fm.FreemarkerBuilderUtil
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.ResponseEntity
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import org.springframework.stereotype.Service
import java.util.*


@Service
class EmailLogService(
    val dao: EmailLogDao,
    val emailServerDao: EmailServerDao,
    val freemarkerBuilderUtil: FreemarkerBuilderUtil,
    val objectMapper: ObjectMapper,
    val sqsClient: AmazonSQS,
    val sesClient: AmazonSimpleEmailService,
    val emailLogDao: EmailLogDao,
    val emailProperties: AmazonEmailProperties
) : BaseService<EmailLog, Long>(dao = dao) {
    fun sendToQueue(emailLog: EmailLog): ResponseEntity<*> {
        emailLog.status = TaskStatus.TODO
        val p = emailLogDao.save(emailLog)
        val messageAttributes: MutableMap<String, MessageAttributeValue> = HashMap()
        messageAttributes["AttributeOne"] = MessageAttributeValue()
            .withStringValue("This is an attribute")
            .withDataType("String")
        val sendMessageStandardQueue = SendMessageRequest()
            .withQueueUrl("https://sqs.ap-southeast-2.amazonaws.com/145278190990/email")
            .withMessageBody(objectMapper.writeValueAsString(p))
            .withDelaySeconds(30)
            .withMessageAttributes(messageAttributes)

        val result = sqsClient.sendMessage(sendMessageStandardQueue)
        println(result)
        return emailLog.responseEntityOk()
    }

    fun readFromQueue() {
        val receiveMessageRequest = ReceiveMessageRequest("https://sqs.ap-southeast-2.amazonaws.com/145278190990/email")
            .withWaitTimeSeconds(20)
            .withMaxNumberOfMessages(10)

        val sqsMessages: List<com.amazonaws.services.sqs.model.Message> =
            sqsClient.receiveMessage(receiveMessageRequest).messages
        sqsMessages.forEach {
            val message: EmailLog = objectMapper.readValue(it.body)
            val request = SendEmailRequest()
                .withDestination(
                    Destination().withToAddresses(message.sendTo)
                )
                .withMessage(
                    Message()
                        .withBody(Body().withHtml(Content().withCharset("UTF-8").withData(message.content!!)))
                        .withSubject(Content().withCharset("UTF-8").withData(message.subject))
                )
                .withSource(emailProperties.sendFrom)
            sesClient.sendEmail(request)
            val emailLog = emailLogDao.findByIdOrNull(message.id)
            if (emailLog != null) {
                emailLog.status = TaskStatus.SUCCESS
                emailLogDao.save(emailLog)
            }
            val deleteMessageRequest = DeleteMessageRequest()
            deleteMessageRequest.queueUrl = emailProperties.queueUrl
            deleteMessageRequest.receiptHandle = it.receiptHandle
            val response = sqsClient.deleteMessage(deleteMessageRequest)
        }
    }

    fun send(emailLog: EmailLog): Pair<String, Boolean> {
        val emailServer = emailServerDao.findAll()[0]!!
        return try {
            val request = SendEmailRequest()
                .withDestination(
                    Destination().withToAddresses(emailLog.sendTo)
                )
                .withMessage(
                    Message()
                        .withBody(Body().withHtml(Content().withCharset("UTF-8").withData(emailLog.content!!)))
                        .withSubject(Content().withCharset("UTF-8").withData(emailLog.subject))
                )
                .withSource(emailServer.fromAddress)
            sesClient.sendEmail(request)
            Pair("", true)
        } catch (e: Exception) {
            e.printStackTrace()
            Pair(e.message!!, false)
        }
    }

    private fun createSender(): JavaMailSender {
        val emailServer = emailServerDao.findAll()[0]
        val sender = JavaMailSenderImpl()
        sender.host = emailServer.host
        sender.port = emailServer.port
        sender.username = emailServer.username
        sender.password = emailServer.password
        sender.javaMailProperties.setProperty("mail.smtp.starttls.enable", "true")
        sender.javaMailProperties.setProperty("mail.smtp.auth", "true")
        sender.javaMailProperties.setProperty("mail.smtp.timeout", emailServer.timeout.toString())
        sender.javaMailProperties.setProperty("mail.smtp.ssl.trust", emailServer.host)
        sender.javaMailProperties.setProperty("mail.smtp.socketFactory.fallback", "false")
        return sender
    }

    fun sendSystem(
        orderId: String = "",
        subject: String,
        sendTo: String,
        ftl: String,
        model: Map<String, Any?>,
        attachment: String? = null
    ) {
        val m = model.toMutableMap()
        val emailLog = EmailLog(
            times = 0,
            sendTo = sendTo,
            subject = subject,
            content = freemarkerBuilderUtil.build(ftl, m)!!,
            attachment = attachment,
            status = TaskStatus.TODO
        )
        dao.save(emailLog)

    }

    fun execute() {
        val list = searchByFilter(mapOf("status_in" to "TODO,FAILURE"), Pageable.unpaged()).content
        list.forEach { item ->
            val resultVO = send(item)
            val result: EmailLog
            result = when {
                resultVO.second -> item.copy(
                    status = TaskStatus.SUCCESS
                ).apply {
                    this.id = item.id
                    this.version = item.version
                }
                else -> item.copy(
                    status = TaskStatus.FAILURE,
                    times = item.times!!.inc(),
                    msg = resultVO.first
                ).apply {
                    this.id = item.id
                    this.version = item.version
                }
            }
            dao.save(result)
        }
    }

    fun resend(id: Long) {
        dao.findById(id).ifPresent {
            it.status = TaskStatus.TODO
            dao.save(it)
        }
    }
}
