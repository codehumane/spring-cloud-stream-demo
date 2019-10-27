package codehumane.springcloudstreamdemo.core.domain

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageInitializationRepository : CrudRepository<MessageInitialization, Long>