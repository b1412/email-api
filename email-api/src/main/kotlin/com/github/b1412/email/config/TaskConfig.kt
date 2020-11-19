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
    @Scheduled(fixedRate = 60_000L)
    fun sendEmail() {
        println("email send")
        SecurityContextHolder.getContext().authentication = AnonAuthentication()
        emailLogService.execute()
    }
}