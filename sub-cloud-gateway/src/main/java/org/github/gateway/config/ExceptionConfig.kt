package org.github.gateway.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.github.gateway.handler.ExceptionHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered.HIGHEST_PRECEDENCE
import org.springframework.core.annotation.Order

@Configuration
class ExceptionConfig {
    @Order(HIGHEST_PRECEDENCE)
    @Bean
    fun errorWebExceptionHandler(mapper: ObjectMapper) = ExceptionHandler(mapper)
}
