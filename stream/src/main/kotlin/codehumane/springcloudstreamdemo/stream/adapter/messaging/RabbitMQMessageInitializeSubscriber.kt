package codehumane.springcloudstreamdemo.stream.adapter.messaging

import codehumane.springcloudstreamdemo.core.domain.MessageInitialized
import codehumane.springcloudstreamdemo.stream.application.MessageApplicationService
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class RabbitMQMessageInitializeSubscriber(private val messageApplicationService: MessageApplicationService) {

    @RabbitListener(queues = ["\${app.rabbitmq.queue.name}"])
    fun receiveInitialized(event: MessageInitialized) {
        messageApplicationService.createBy(event)
    }

}