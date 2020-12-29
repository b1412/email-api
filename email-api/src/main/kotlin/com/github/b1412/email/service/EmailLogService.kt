package com.github.b1412.email.service

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder
import com.amazonaws.services.simpleemail.model.*
import com.github.b1412.api.service.BaseService
import com.github.b1412.email.dao.EmailLogDao
import com.github.b1412.email.dao.EmailServerDao
import com.github.b1412.email.entity.EmailLog
import com.github.b1412.email.enum.TaskStatus
import com.github.b1412.fm.FreemarkerBuilderUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import org.springframework.stereotype.Service


@Service
class EmailLogService(
    @Autowired
    val dao: EmailLogDao,
    @Autowired
    val emailServerDao: EmailServerDao,
    @Autowired
    val freemarkerBuilderUtil: FreemarkerBuilderUtil
) : BaseService<EmailLog, Long>(dao = dao) {
    fun send(emailLog: EmailLog): Pair<String, Boolean> {
        val emailServer = emailServerDao.findAll()[0]!!
        return try {
            val sesClient = AmazonSimpleEmailServiceClientBuilder.standard()
                .withCredentials(
                    AWSStaticCredentialsProvider(
                        BasicAWSCredentials(emailServer.username, emailServer.password)
                    )
                ).withRegion(Regions.AP_SOUTHEAST_2).build()
            val request = SendEmailRequest()
                .withDestination(
                    Destination().withToAddresses(emailLog.sendTo)
                )
                .withMessage(
                    Message()
                        .withBody(
                            Body()
                                .withHtml(
                                    Content()
                                        .withCharset("UTF-8").withData(emailLog.content!!)
                                )
                        )
                        .withSubject(
                            Content()
                                .withCharset("UTF-8").withData(emailLog.subject)
                        )
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
