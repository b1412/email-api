package com.github.b1412.email.controller.custom

import com.github.b1412.aws.s3.AmazonService
import com.github.b1412.email.enum.AttachmentType
import com.github.b1412.email.service.AttachmentService
import com.github.b1412.generator.metadata.PermissionFeatureIgnore
import org.apache.commons.io.IOUtils
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.FileInputStream
import javax.servlet.http.HttpServletResponse

@PermissionFeatureIgnore
@RestController
@RequestMapping("/v1/attachment")
class AttachmentControllerCustom(
    val amazonService: AmazonService,
    val attachmentService: AttachmentService
) {
    @GetMapping("/download")
    fun download(
        @RequestParam filename: String,
        scale: Double?,
        height: Int?,
        width: Int?,
        response: HttpServletResponse
    ) {
        response.setHeader("Content-Disposition", "inline; filename=$filename")
        response.contentType = "application/octet-stream"
        val file = amazonService.getFile(filename)
        IOUtils.copy(FileInputStream(file), response.outputStream)
        response.flushBuffer()
    }

    @PostMapping("/upload")
    @ResponseBody
    fun create(type: AttachmentType?, file: MultipartFile): ResponseEntity<*> {
        return attachmentService
            .createFile(type, file)
            .fold(
                { ResponseEntity.ok(it) },
                { attachment ->
                    attachmentService.save(attachment)
                    ResponseEntity.ok(attachment)
                }
            )
    }

}