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
    @PostMapping("/send/{id}")
    @PermissionFeatures(
        PermissionFeature(role = "admin", rule = "all")
    )
    fun sendTestEmail(@PathVariable id: Long, @RequestBody vo: TestEmailVo) {
        val map = vo.params.split("&").map {
            val (key, value) = it.split("=")
            Pair(key, value)
        }.toMap().toMutableMap()
        emailTemplateService.send(id, vo.email, map)
    }
}

data class TestEmailVo(val email: String, val params: String)