package codehumane.springcloudstreamdemo.core.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class MessageInitialization(

    var userId: String,
    var templateId: String,
    var params: String,
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null,
    var createdMessageId: Long? = null

)