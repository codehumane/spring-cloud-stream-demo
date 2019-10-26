package codehumane.springcloudstreamdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.stereotype.Service

@SpringBootApplication
@EnableBinding(Sink::class)
class SpringCloudStreamDemoApplication

fun main(args: Array<String>) {
    runApplication<SpringCloudStreamDemoApplication>(*args)
}

@Service
class StreamApplicationService {

    @StreamListener(Sink.INPUT)
    fun handle(message: String) {
        println("Received: $message")
    }

}
