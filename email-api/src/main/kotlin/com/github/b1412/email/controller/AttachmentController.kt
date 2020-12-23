package com.github.b1412.email.controller

import com.github.b1412.aws.s3.AmazonService
import com.github.b1412.email.controller.base.BaseAttachmentController
import com.github.b1412.email.service.AttachmentService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/v1/attachment")
class AttachmentController(
    val amazonService: AmazonService,
    val attachmentService: AttachmentService
) : BaseAttachmentController()