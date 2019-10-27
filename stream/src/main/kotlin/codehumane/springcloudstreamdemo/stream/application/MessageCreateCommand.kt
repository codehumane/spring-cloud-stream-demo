package codehumane.springcloudstreamdemo.stream.application

data class MessageCreateCommand(
    val userId: String,
    val templateId: String,
    val params: Map<String, String>
)