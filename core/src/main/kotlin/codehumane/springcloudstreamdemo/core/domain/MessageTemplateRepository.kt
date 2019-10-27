package codehumane.springcloudstreamdemo.core.domain

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MessageTemplateRepository : CrudRepository<MessageTemplate, Long> {

    fun findByTemplateId(templateId: String): Optional<MessageTemplate>

}