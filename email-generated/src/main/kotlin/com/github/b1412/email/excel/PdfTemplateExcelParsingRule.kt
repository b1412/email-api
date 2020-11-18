package com.github.b1412.email.excel

import com.github.b1412.email.entity.PdfTemplate
import com.github.b1412.excel.service.ExcelParsingRule
import com.github.b1412.files.parser.FileParser
import com.github.b1412.excel.convertor.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.persistence.EntityManager


@Component
class PdfTemplateExcelParsingRule(
        @Autowired
        val entityManager: EntityManager

) : ExcelParsingRule<PdfTemplate> {

    override val fileParser: FileParser
    get() {
        val fileParser = FileParser()
        fileParser.start = 1
    fileParser.addCell(1, "name")
    fileParser.addCell(2, "notes")
    fileParser.addCell(3, "id", LongConvertor())
    fileParser.addCell(4, "version", LongConvertor())
    fileParser.addCell(5, "createdAt")
    fileParser.addCell(6, "updatedAt")
    fileParser.addCell(7, "deletedAt")
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
    get() = PdfTemplate::class.java

    override val ruleName: String
    get() = "pdfTemplate"

    override fun process(data: List<PdfTemplate>) {
        data.forEach{
            entityManager.persist(it)
        }
    }
}
