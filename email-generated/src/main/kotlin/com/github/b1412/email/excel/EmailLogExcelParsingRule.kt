package com.github.b1412.email.excel

import com.github.b1412.email.entity.EmailLog
import com.github.b1412.excel.service.ExcelParsingRule
import com.github.b1412.files.parser.FileParser
import com.github.b1412.excel.convertor.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.persistence.EntityManager


@Component
class EmailLogExcelParsingRule(
        @Autowired
        val entityManager: EntityManager

) : ExcelParsingRule<EmailLog> {

    override val fileParser: FileParser
    get() {
        val fileParser = FileParser()
        fileParser.start = 1
    fileParser.addCell(1, "subject")
    fileParser.addCell(2, "content")
    fileParser.addCell(3, "sendTo")
    fileParser.addCell(4, "status")
    fileParser.addCell(5, "times")
    fileParser.addCell(6, "msg")
    fileParser.addCell(7, "orderId")
    fileParser.addCell(8, "attachment")
    fileParser.addCell(9, "id", LongConvertor())
    fileParser.addCell(10, "version", LongConvertor())
    fileParser.addCell(11, "createdAt")
    fileParser.addCell(12, "updatedAt")
    fileParser.addCell(13, "deletedAt")
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
    get() = EmailLog::class.java

    override val ruleName: String
    get() = "emailLog"

    override fun process(data: List<EmailLog>) {
        data.forEach{
            entityManager.persist(it)
        }
    }
}
