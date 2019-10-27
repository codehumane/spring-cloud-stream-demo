package codehumane.springcloudstreamdemo.stream.adapter.messaging

import codehumane.springcloudstreamdemo.core.domain.MessageInitialized
import codehumane.springcloudstreamdemo.stream.application.MessageCommandService
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.stereotype.Component

@Component
class RabbitMQMessageInitializeSubscriber(private val messageCommandService: MessageCommandService) {

    @StreamListener(Sink.INPUT)
    fun receiveInitialized(event: MessageInitialized) {
        messageCommandService.createBy(event)
    }

}