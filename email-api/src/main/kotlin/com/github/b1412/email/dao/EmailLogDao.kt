package com.github.b1412.email.dao

import com.github.b1412.api.dao.BaseDao
import com.github.b1412.email.entity.EmailLog
import org.springframework.stereotype.Repository

@Repository
interface EmailLogDao : BaseDao<EmailLog, Long>
