package com.github.b1412.email.config

import com.github.b1412.email.service.EmailLogService
import com.github.b1412.security.AnonAuthentication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.security.core.context.SecurityContextHolder

@Configuration
@EnableScheduling
class TaskConfig(
    @Autowired
    val emailLogService: EmailLogService
) {
    @Scheduled(cron = "\${email.cron}")
    fun sendEmail() {
        SecurityContextHolder.getContext().authentication = AnonAuthentication()
        emailLogService.readFromQueue()
    }
}