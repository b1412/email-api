package com.github.b1412.email.excel

import com.github.b1412.email.entity.EmailServer
import com.github.b1412.excel.service.ExcelParsingRule
import com.github.b1412.files.parser.FileParser
import com.github.b1412.excel.convertor.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.persistence.EntityManager


@Component
class EmailServerExcelParsingRule(
        @Autowired
        val entityManager: EntityManager

) : ExcelParsingRule<EmailServer> {

    override val fileParser: FileParser
    get() {
        val fileParser = FileParser()
        fileParser.start = 1
    fileParser.addCell(1, "host")
    fileParser.addCell(2, "timeout")
    fileParser.addCell(3, "port")
    fileParser.addCell(4, "alias")
    fileParser.addCell(5, "fromAddress")
    fileParser.addCell(6, "username")
    fileParser.addCell(7, "password")
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
    get() = EmailServer::class.java

    override val ruleName: String
    get() = "emailServer"

    override fun process(data: List<EmailServer>) {
        data.forEach{
            entityManager.persist(it)
        }
    }
}
