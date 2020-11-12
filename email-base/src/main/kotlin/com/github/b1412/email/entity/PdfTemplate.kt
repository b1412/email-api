package com.github.b1412.email.entity

import com.github.b1412.api.entity.BaseEntity
import com.github.b1412.generator.metadata.EntityFeature
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Column
import javax.persistence.Entity
import javax.validation.constraints.NotNull

@EntityFeature
@Entity
@DynamicUpdate
@DynamicInsert

data class PdfTemplate(
        @field:NotNull
        @Column(unique = true)
        val name: String,
        val notes: String? = null
) : BaseEntity()
