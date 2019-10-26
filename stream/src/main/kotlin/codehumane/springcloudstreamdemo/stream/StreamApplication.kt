package codehumane.springcloudstreamdemo.stream

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.function.Consumer

@SpringBootApplication
@EnableBinding(Sink::class)
class StreamApplication

fun main(args: Array<String>) {
    runApplication<StreamApplication>(*args)
}

@Configuration
class StreamListenerConfig {

    @Bean
    fun loggingConsumer(): Consumer<String> = Consumer {
        println("Received: $it")
    }

}
