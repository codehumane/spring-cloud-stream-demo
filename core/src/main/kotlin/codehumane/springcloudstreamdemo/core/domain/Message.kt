package codehumane.springcloudstreamdemo.core.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Message(
    var userId: String,
    var contents: String,
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null
)