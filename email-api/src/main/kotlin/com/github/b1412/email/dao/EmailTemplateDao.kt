package com.github.b1412.email.dao

import com.github.b1412.api.dao.BaseDao
import com.github.b1412.email.entity.EmailTemplate
import org.springframework.stereotype.Repository

@Repository
interface EmailTemplateDao : BaseDao<EmailTemplate, Long>
