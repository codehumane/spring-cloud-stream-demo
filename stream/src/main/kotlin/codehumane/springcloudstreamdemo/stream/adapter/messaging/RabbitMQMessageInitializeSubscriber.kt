package codehumane.springcloudstreamdemo.stream.adapter.messaging

import codehumane.springcloudstreamdemo.stream.application.MessageCommandService
import codehumane.springcloudstreamdemo.stream.application.MessageCreateCommand
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.stereotype.Component

@Component
class RabbitMQMessageInitializeSubscriber(private val messageCommandService: MessageCommandService) {

    @StreamListener(Sink.INPUT)
    fun receiveInitialized(command: MessageCreateCommand) {
        messageCommandService.create(command)
    }

}