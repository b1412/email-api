package com.github.b1412.email.excel

import com.github.b1412.email.entity.EmailTemplate
import com.github.b1412.excel.service.ExcelParsingRule
import com.github.b1412.files.parser.FileParser
import com.github.b1412.excel.convertor.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.persistence.EntityManager


@Component
class EmailTemplateExcelParsingRule(
        @Autowired
        val entityManager: EntityManager

) : ExcelParsingRule<EmailTemplate> {

    override val fileParser: FileParser
    get() {
        val fileParser = FileParser()
        fileParser.start = 1
    fileParser.addCell(1, "name")
    fileParser.addCell(2, "subject")
    fileParser.addCell(3, "layout")
    fileParser.addCell(4, "content")
    fileParser.addCell(5, "type")
    fileParser.addCell(6, "notes")
    fileParser.addCell(7, "id", LongConvertor())
    fileParser.addCell(8, "version", LongConvertor())
    fileParser.addCell(9, "createdAt")
    fileParser.addCell(10, "updatedAt")
    fileParser.addCell(11, "deletedAt")
        fileParser.addCell(2, "category", EntityConvertor().apply {
                name = "Creator"
                em = entityManager
        })
        fileParser.addCell(2, "category", EntityConvertor().apply {
                name = "Modifier"
                em = entityManager
        })
        return fileParser
    }

    override val entityClass: Class<*>
    get() = EmailTemplate::class.java

    override val ruleName: String
    get() = "emailTemplate"

    override fun process(data: List<EmailTemplate>) {
        data.forEach{
            entityManager.persist(it)
        }
    }
}
