package com.github.b1412.email.excel

import com.github.b1412.email.entity.Attachment
import com.github.b1412.excel.service.ExcelParsingRule
import com.github.b1412.files.parser.FileParser
import com.github.b1412.excel.convertor.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.persistence.EntityManager


@Component
class AttachmentExcelParsingRule(
        @Autowired
        val entityManager: EntityManager

) : ExcelParsingRule<Attachment> {

    override val fileParser: FileParser
    get() {
        val fileParser = FileParser()
        fileParser.start = 1
    fileParser.addCell(1, "name")
    fileParser.addCell(2, "contentType")
    fileParser.addCell(3, "size")
    fileParser.addCell(4, "originalFilename")
    fileParser.addCell(5, "notes")
    fileParser.addCell(6, "fullPath")
    fileParser.addCell(7, "type")
    fileParser.addCell(8, "id", LongConvertor())
    fileParser.addCell(9, "version", LongConvertor())
    fileParser.addCell(10, "createdAt")
    fileParser.addCell(11, "updatedAt")
    fileParser.addCell(12, "deletedAt")
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
    get() = Attachment::class.java

    override val ruleName: String
    get() = "attachment"

    override fun process(data: List<Attachment>) {
        data.forEach{
            entityManager.persist(it)
        }
    }
}
