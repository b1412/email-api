package com.github.b1412.email.controller.custom

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.sqs.AmazonSQS
import com.amazonaws.services.sqs.AmazonSQSClientBuilder
import com.amazonaws.services.sqs.model.*
import com.github.b1412.email.dao.EmailServerDao
import com.github.b1412.email.entity.EmailLog
import com.github.b1412.email.service.EmailLogService
import com.github.b1412.extenstions.responseEntityOk
import com.github.b1412.generator.metadata.PermissionFeatureIgnore
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@PermissionFeatureIgnore
@RestController
@RequestMapping("/v1/sqs")
class SqsControllerCustom(
    val emailServerDao: EmailServerDao,
    val emailLogService: EmailLogService
) {

    @PostMapping("/send-to-queue")
    fun sendToQueue(@RequestBody emailLog: EmailLog) {
        emailLogService.sendToQueue(emailLog)
    }

    @PostMapping("/send")
    fun test(): ResponseEntity<SendMessageResult> {
        val emailServer = emailServerDao.findAll()[0]!!
        val sqs: AmazonSQS = AmazonSQSClientBuilder.standard()
            .withCredentials(
                AWSStaticCredentialsProvider(
                    BasicAWSCredentials(emailServer.username, emailServer.password)
                )
            )
            .withRegion(Regions.AP_SOUTHEAST_2)
            .build()
        val messageAttributes: MutableMap<String, MessageAttributeValue> = HashMap()
        messageAttributes["AttributeOne"] = MessageAttributeValue()
            .withStringValue("This is an attribute")
            .withDataType("String")

        val sendMessageStandardQueue = SendMessageRequest()
            .withQueueUrl("https://sqs.ap-southeast-2.amazonaws.com/145278190990/email")
            .withMessageBody("A simple message.")
            .withDelaySeconds(30)
            .withMessageAttributes(messageAttributes)

        val result = sqs.sendMessage(sendMessageStandardQueue)
        return result.responseEntityOk()
    }

    @GetMapping("/read-from-queue")
    fun readFromQueue() {
        emailLogService.readFromQueue()
    }

    @GetMapping("/get")
    fun getMessages(): ResponseEntity<List<Message>> {
        val emailServer = emailServerDao.findAll()[0]!!
        val sqs: AmazonSQS = AmazonSQSClientBuilder.standard()
            .withCredentials(
                AWSStaticCredentialsProvider(
                    BasicAWSCredentials(emailServer.username, emailServer.password)
                )
            )
            .withRegion(Regions.AP_SOUTHEAST_2)
            .build()


        val receiveMessageRequest = ReceiveMessageRequest("https://sqs.ap-southeast-2.amazonaws.com/145278190990/email")
            .withWaitTimeSeconds(10)
            .withMaxNumberOfMessages(10)

        val sqsMessages: List<Message> = sqs.receiveMessage(receiveMessageRequest).messages
        println(sqsMessages)
        sqsMessages.forEach {
            val deleteMessageRequest = DeleteMessageRequest()
            deleteMessageRequest.queueUrl = "https://sqs.ap-southeast-2.amazonaws.com/145278190990/email"
            deleteMessageRequest.receiptHandle = it.receiptHandle
            val response = sqs.deleteMessage(deleteMessageRequest)
            println(response)
        }
        return sqsMessages.responseEntityOk()
    }

}