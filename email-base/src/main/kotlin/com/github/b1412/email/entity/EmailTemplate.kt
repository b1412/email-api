package com.github.b1412.email.entity

import com.github.b1412.api.entity.BaseEntity
import com.github.b1412.generator.metadata.EntityFeature
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Column
import javax.persistence.Entity

@EntityFeature
@Entity
@DynamicUpdate
@DynamicInsert
data class EmailTemplate(
        var name: String = "",
        var subject: String = "",
        var layout: String = "",
        @Column(columnDefinition = "TEXT")
        var content: String = "",

        var type: String? = null,

        val notes: String? = null

) : BaseEntity()