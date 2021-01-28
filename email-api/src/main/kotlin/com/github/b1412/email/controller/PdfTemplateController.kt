package com.github.b1412.email.controller

import com.github.b1412.email.controller.base.BasePdfTemplateController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/pdf-template")
class PdfTemplateController : BasePdfTemplateController()