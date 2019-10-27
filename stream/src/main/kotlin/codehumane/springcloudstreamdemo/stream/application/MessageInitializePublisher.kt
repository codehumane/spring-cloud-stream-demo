package codehumane.springcloudstreamdemo.stream.application

interface MessageInitializePublisher {

    fun sendInitialized(command: MessageCreateCommand)

}