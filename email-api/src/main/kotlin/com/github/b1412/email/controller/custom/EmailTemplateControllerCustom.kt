package com.github.b1412.email.controller.custom

import com.github.b1412.email.service.EmailTemplateService
import com.github.b1412.generator.metadata.PermissionFeature
import com.github.b1412.generator.metadata.PermissionFeatures
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/email-template")
class EmailTemplateControllerCustom(
    val emailTemplateService: EmailTemplateService
) {
    @PostMapping("/send/{id}/{email}")
    @PermissionFeatures(
        PermissionFeature(role = "admin", rule = "all")
    )
    fun sendTestEmail(@PathVariable id: Long, @PathVariable email: String) {
        emailTemplateService.send(id, email, mutableMapOf())
    }
}