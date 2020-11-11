package com.github.b1412.email.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.github.b1412.api.entity.BaseEntity
import com.github.b1412.email.enum.TaskStatus
import com.github.b1412.generator.metadata.EntityFeature
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import java.io.Serializable
import javax.persistence.*

@EntityFeature
@Entity
@DynamicUpdate
@DynamicInsert

data class EmailLog(

        val subject: String? = null,
        @Lob
        @Column(length = 100000)
        val content: ByteArray? = null,
        val sendTo: String? = null,
        @Enumerated(value = EnumType.STRING)
        val status: TaskStatus? = null,
        var times: Int? = null,
        @Column(columnDefinition = "TEXT")
        val msg: String? = null,
        val orderId: String? = null,
        val attachment: String? = null
) : BaseEntity(), Serializable
