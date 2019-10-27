package codehumane.springcloudstreamdemo.stream.adapter.rest

import codehumane.springcloudstreamdemo.stream.application.MessageCommandService
import codehumane.springcloudstreamdemo.stream.application.MessageCreateCommand
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageInitializeController(
    private val messageCommandService: MessageCommandService
) {

    @PostMapping("/alarm/message")
    fun initialize(@RequestBody command: MessageCreateCommand) {
        messageCommandService.initialize(command)
    }

}