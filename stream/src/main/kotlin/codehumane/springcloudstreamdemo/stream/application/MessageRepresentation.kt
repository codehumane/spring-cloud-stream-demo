package codehumane.springcloudstreamdemo.stream.application

data class MessageRepresentation(
    val id: Long,
    val userId: String,
    val content: String
)