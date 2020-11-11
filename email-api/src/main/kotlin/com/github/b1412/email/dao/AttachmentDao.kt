package com.github.b1412.email.dao

import com.github.b1412.api.dao.BaseDao
import com.github.b1412.email.entity.Attachment
import org.springframework.stereotype.Repository

@Repository
interface AttachmentDao : BaseDao<Attachment, Long>
