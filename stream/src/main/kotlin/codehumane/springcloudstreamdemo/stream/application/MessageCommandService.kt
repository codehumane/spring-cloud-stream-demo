package codehumane.springcloudstreamdemo.stream.application

import org.springframework.stereotype.Service

@Service
class MessageCommandService(private val messageInitializePublisher: MessageInitializePublisher) {

    fun initialize(command: MessageCreateCommand) {
        messageInitializePublisher.sendInitialized(command)
        println("alarm message create initialized - payload: $command")
    }

    fun create(command: MessageCreateCommand) {
        println("alarm message create finished - payload: $command")
    }

}
