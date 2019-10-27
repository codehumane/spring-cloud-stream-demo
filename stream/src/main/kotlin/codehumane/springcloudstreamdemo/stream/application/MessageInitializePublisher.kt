package codehumane.springcloudstreamdemo.stream.application

import codehumane.springcloudstreamdemo.core.domain.MessageInitialized

interface MessageInitializePublisher {

    fun sendInitialized(command: MessageInitialized)

}