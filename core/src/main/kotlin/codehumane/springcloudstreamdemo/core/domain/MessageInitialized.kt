package codehumane.springcloudstreamdemo.core.domain

data class MessageInitialized(
    val userId: String,
    val templateId: String,
    val params: String,
    val id: Long
)