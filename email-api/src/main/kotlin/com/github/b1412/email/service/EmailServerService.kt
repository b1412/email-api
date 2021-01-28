package com.github.b1412.email.service

import com.github.b1412.api.service.BaseService
import com.github.b1412.email.dao.EmailServerDao
import com.github.b1412.email.entity.EmailServer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class EmailServerService(
    @Autowired
    val dao: EmailServerDao
) : BaseService<EmailServer, Long>(dao = dao)
