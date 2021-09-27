package com.github.b1412.email.config


import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import javax.validation.constraints.NotBlank

@Configuration
@ConfigurationProperties("aws.email")
data class AmazonEmailProperties(
    @NotBlank
    var sendFrom: String? = null,

    @NotBlank
    var queueUrl: String? = null,

    @NotBlank
    var accessKey: String? = null,

    @NotBlank
    var secretKey: String? = null

)
