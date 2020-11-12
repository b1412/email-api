package com.github.b1412.email.service

import com.github.b1412.api.service.BaseService
import com.github.b1412.email.dao.PdfTemplateDao
import com.github.b1412.email.entity.PdfTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class PdfTemplateService(
@Autowired
val dao: PdfTemplateDao
) : BaseService<PdfTemplate, Long>(dao = dao)
