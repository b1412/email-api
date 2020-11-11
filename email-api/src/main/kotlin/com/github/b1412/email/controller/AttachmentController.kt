package com.github.b1412.email.controller

import com.github.b1412.aws.s3.AmazonService
import com.github.b1412.email.controller.base.BaseAttachmentController
import com.github.b1412.email.service.AttachmentService
import org.apache.commons.io.IOUtils
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.FileInputStream
import javax.servlet.http.HttpServletResponse


@RestController
@RequestMapping("/v1/attachment")
class AttachmentController(
        val amazonService: AmazonService,
        val attachmentService: AttachmentService
) : BaseAttachmentController() {
    @GetMapping("/download")
    fun download(@RequestParam filename: String, scale: Double?, height: Int?, width: Int?, response: HttpServletResponse) {
        response.setHeader("Content-Disposition", "inline; filename=$filename")
        response.contentType = "application/octet-stream"
        val file = amazonService.getFile(filename)
        IOUtils.copy(FileInputStream(file), response.outputStream)
        response.flushBuffer()
    }

    @PostMapping("/upload")
    @ResponseBody
    fun create(file: MultipartFile): ResponseEntity<*> {
        return attachmentService
                .createFile(file)
                .fold(
                        { ResponseEntity.ok(it) },
                        { attachment ->
                            attachmentService.save(attachment)
                            ResponseEntity.ok(attachment)
                        }
                )
    }

}