package com.github.b1412.email.entity

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
    @Column(columnDefinition = "text")
    val content: String? = null,
    val sendTo: String? = null,
    @Enumerated(value = EnumType.STRING)
    var status: TaskStatus? = null,
    var times: Int? = null,
    @Column(columnDefinition = "text")
    val msg: String? = null,
    val attachment: String? = null
) : BaseEntity(), Serializable
