package com.github.b1412.email.controller.custom

import com.github.b1412.email.controller.base.BaseEmailLogController
import com.github.b1412.email.service.EmailLogService
import com.github.b1412.generator.metadata.PermissionFeature
import com.github.b1412.generator.metadata.PermissionFeatures
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/email-log")
class EmailLogControllerCustom(
    val emailLogService: EmailLogService
) : BaseEmailLogController() {
    @PostMapping("/resend/{id}")
    @PermissionFeatures(
        PermissionFeature(role = "admin", rule = "all")
    )
    fun resendEmail(@PathVariable id: Long) {
        emailLogService.resend(id)
    }

    @PostMapping("/dev-send-all")
    @PermissionFeatures(
        PermissionFeature(role = "admin", rule = "all")
    )
    fun sendAll() {
        emailLogService.execute()
    }
}