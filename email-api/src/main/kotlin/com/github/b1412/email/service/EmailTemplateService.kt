package com.github.b1412.email.service

import com.github.b1412.api.service.BaseService
import com.github.b1412.email.dao.EmailTemplateDao
import com.github.b1412.email.entity.EmailTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class EmailTemplateService(
        @Autowired
        val dao: EmailTemplateDao
) : BaseService<EmailTemplate, Long>(dao = dao)
