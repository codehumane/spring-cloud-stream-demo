package codehumane.springcloudstreamdemo.stream.config

import codehumane.springcloudstreamdemo.core.domain.MessageTemplate
import codehumane.springcloudstreamdemo.core.domain.MessageTemplateRepository
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import javax.annotation.PostConstruct

@Configuration
@EntityScan(basePackages = ["codehumane.springcloudstreamdemo.core.domain"])
@EnableJpaRepositories(basePackages = ["codehumane.springcloudstreamdemo.core.domain"])
class DbConfig(private val messageTemplateRepository: MessageTemplateRepository) {

    @PostConstruct
    fun prepareTemplateData() {
        messageTemplateRepository.save(
            MessageTemplate(
                "Hi, my name is %s and I'm %d years old",
                "T00001"
            )
        )
    }
}
