package codehumane.springcloudstreamdemo.stream.application

import codehumane.springcloudstreamdemo.core.domain.*
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service

@Service
class MessageApplicationService(
    private val objectMapper: ObjectMapper,
    private val messageInitializePublisher: MessageInitializePublisher,
    private val messageInitializationRepository: MessageInitializationRepository,
    private val messageTemplateRepository: MessageTemplateRepository,
    private val messageRepository: MessageRepository
) {

    fun initialize(command: MessageCreateCommand) {
        val initialization = saveInitialization(command)
        sendInitialized(initialization)
        println("alarm message create initialized - payload: $command")
    }

    private fun saveInitialization(command: MessageCreateCommand): MessageInitialization {
        val initialization = command.let {
            MessageInitialization(
                it.userId,
                it.templateId,
                objectMapper.writeValueAsString(it.params)
            )
        }

        return messageInitializationRepository.save(initialization)
    }

    private fun sendInitialized(initialization: MessageInitialization) {
        val initialized = initialization.let {
            MessageInitialized(
                it.userId,
                it.templateId,
                it.params,
                it.id!!
            )
        }

        messageInitializePublisher.sendInitialized(initialized)
    }

    fun createBy(event: MessageInitialized) {
        val message = createMessage(event)
        setCreatedMessageIdToInitialization(event, message)
        println("alarm message create finished - $message")
    }

    private fun createMessage(event: MessageInitialized): Message {
        val template = messageTemplateRepository
            .findByTemplateId(event.templateId)
            .orElseThrow { IllegalStateException("존재하지 않는 템플릿 아이디(${event.templateId}) 입니다.") }

        val parameters = try {
            objectMapper.readValue(event.params, MessageParameters::class.java)
        } catch (e: Exception) {
            throw IllegalStateException(
                "잘못된 파라미터가 전달 되었습니다 - 템플릿 아이디: ${event.templateId}, 파라미터: ${event.params}",
                e
            )
        }

        val content = String.format(
            template.contents,
            parameters.name,
            parameters.age
        )

        val message = Message(
            event.userId,
            content
        )

        return messageRepository.save(message)
    }

    private fun setCreatedMessageIdToInitialization(event: MessageInitialized, message: Message) {
        val initialization = messageInitializationRepository.findById(event.id)

        if (!initialization.isPresent) {
            println("Initialization(${event.id})을 찾을 수 없어, 메시지 생성 결과를 기록에 실패함.")
            return
        }

        initialization.ifPresent {
            it.createdMessageId = message.id!!
            messageInitializationRepository.save(it)
        }
    }

    fun get(): List<MessageRepresentation> {
        return messageRepository.findAll().map {
            MessageRepresentation(
                it.id!!,
                it.userId,
                it.contents
            )
        }
    }

}
