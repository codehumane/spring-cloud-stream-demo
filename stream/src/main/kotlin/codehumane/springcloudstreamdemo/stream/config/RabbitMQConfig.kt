package codehumane.springcloudstreamdemo.stream.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.core.Queue
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class RabbitMQConfig {

    @Bean
    fun myQueue(@Value("\${app.rabbitmq.queue.name}") queueName: String) = Queue(queueName)

    @Bean
    fun jacksonMessageConverter(objectMapper: ObjectMapper) =
        Jackson2JsonMessageConverter(objectMapper)

}
