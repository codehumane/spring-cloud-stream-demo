package codehumane.springcloudstreamdemo.stream.adapter.messaging

import codehumane.springcloudstreamdemo.core.domain.MessageInitialized
import codehumane.springcloudstreamdemo.stream.application.MessageInitializePublisher
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component

@Component
class RabbitMQMessageInitializePublisher(private val sink: Sink) : MessageInitializePublisher {

    override fun sendInitialized(command: MessageInitialized) {
        sink.input().send(MessageBuilder.withPayload(command).build())
    }

}