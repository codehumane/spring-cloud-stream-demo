package codehumane.springcloudstreamdemo.stream.adapter.messaging

import codehumane.springcloudstreamdemo.core.domain.MessageInitialized
import codehumane.springcloudstreamdemo.stream.application.MessageInitializePublisher
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class RabbitMQMessageInitializePublisher(
    @Value("\${app.rabbitmq.queue.name}") private val queueName: String,
    private val template: AmqpTemplate
) : MessageInitializePublisher {

    override fun sendInitialized(command: MessageInitialized) {
        template.convertAndSend(queueName, command)
    }

}
