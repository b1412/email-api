package com.github.b1412.email.service

import com.github.b1412.api.service.BaseService
import com.github.b1412.email.dao.EmailLogDao
import com.github.b1412.email.entity.EmailLog
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class EmailLogService(
        @Autowired
        val dao: EmailLogDao
) : BaseService<EmailLog, Long>(dao = dao)
