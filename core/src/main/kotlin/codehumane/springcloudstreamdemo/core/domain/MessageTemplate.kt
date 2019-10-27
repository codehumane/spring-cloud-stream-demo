package codehumane.springcloudstreamdemo.core.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class MessageTemplate(
    var contents: String,
    var templateId: String,
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null
)