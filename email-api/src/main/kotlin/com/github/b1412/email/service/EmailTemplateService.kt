package com.github.b1412.email.service

import com.github.b1412.api.service.BaseService
import com.github.b1412.email.dao.EmailTemplateDao
import com.github.b1412.email.entity.EmailTemplate
import freemarker.template.Configuration
import freemarker.template.DefaultObjectWrapper
import freemarker.template.Template
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.io.StringReader
import java.io.StringWriter


@Service
class EmailTemplateService(
        val dao: EmailTemplateDao,
        val emailLogService: EmailLogService
) : BaseService<EmailTemplate, Long>(dao = dao) {
    fun send(templateName: String, emails: String, model: MutableMap<String, String>, pdfFileName: String = "") {
        val emailTemplate = dao.searchByFilter(mapOf("name_eq" to templateName), Pageable.unpaged()).content[0]
        if (emailTemplate == null) {
            throw  IllegalArgumentException("Template $templateName does not exist.")
        }
        send(emailTemplate.id!!, emails, model, pdfFileName)
    }

    fun send(id: Long, emails: String, model: MutableMap<String, String>, pdfFileName: String = "") {
        emails.split(",").forEach { email ->
            val emailTemplate = dao.findByIdOrNull(id)!!
            //  val attachments = (emailTemplate.attachments.map { it.name } + pdfFileName).filter { it.isNotBlank() }
            val cfg = Configuration()
            cfg.objectWrapper = DefaultObjectWrapper()
            val t = Template("templateName", StringReader(emailTemplate.content), cfg)
            val out = StringWriter()
            model["email"] = email
            t.process(model, out)

            val transformedTemplate = out.toString()
            println(transformedTemplate)
            emailLogService.sendSystem(
                    subject = emailTemplate.subject,
                    sendTo = email,
                    ftl = "/email/" + emailTemplate.layout,
                    model = mapOf(
                            "content" to transformedTemplate
                    ),
//                                attachment = if (attachments.isEmpty()) {
//                                        null
//                                } else {
//                                        attachments.joinToString(",")
//                                }
            )

        }
    }
}
