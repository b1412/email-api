package com.github.b1412.email.entity

import com.github.b1412.api.entity.BaseEntity
import com.github.b1412.generator.metadata.EntityFeature
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import java.io.Serializable
import javax.persistence.Entity

@EntityFeature
@Entity
@DynamicUpdate
@DynamicInsert

data class EmailServer(
        var host: String = "",
        var timeout: Int = 60000,
        var port: Int = 587,
        var alias: String = "",
        var fromAddress: String = "",
        var username: String = "",
        var password: String = ""
) : BaseEntity(), Serializable
