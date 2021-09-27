package com.github.b1412.email.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder
import com.amazonaws.services.sqs.AmazonSQS
import com.amazonaws.services.sqs.AmazonSQSClientBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AwsEmailConfig {
    @Autowired
    private val amazonProperties: AmazonEmailProperties? = null

    @Bean
    fun sqsClient(): AmazonSQS {
        return AmazonSQSClientBuilder.standard()
            .withCredentials(
                AWSStaticCredentialsProvider(
                    BasicAWSCredentials(amazonProperties!!.accessKey, amazonProperties.secretKey)
                )
            )
            .withRegion(Regions.AP_SOUTHEAST_2)
            .build()
    }

    @Bean
    fun sesClient(): AmazonSimpleEmailService {
        return AmazonSimpleEmailServiceClientBuilder.standard()
            .withCredentials(
                AWSStaticCredentialsProvider(
                    BasicAWSCredentials(amazonProperties!!.accessKey, amazonProperties.secretKey)
                )
            ).withRegion(Regions.AP_SOUTHEAST_2).build()
    }
}