package codehumane.springcloudstreamdemo.stream.adapter.rest

import codehumane.springcloudstreamdemo.stream.application.MessageApplicationService
import codehumane.springcloudstreamdemo.stream.application.MessageCreateCommand
import codehumane.springcloudstreamdemo.stream.application.MessageRepresentation
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/alarm/message")
class MessageInitializeController(
    private val messageApplicationService: MessageApplicationService
) {

    @PostMapping
    fun initialize(@RequestBody command: MessageCreateCommand) {
        messageApplicationService.initialize(command)
    }

    @GetMapping
    fun messages(): List<MessageRepresentation> {
        return messageApplicationService.get()
    }

}