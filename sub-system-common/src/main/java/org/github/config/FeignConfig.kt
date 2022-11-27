package org.github.config

import feign.Logger.Level.FULL
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@ConditionalOnClass(EnableFeignClients::class)
@Configuration
class FeignConfig {
  @Bean
  fun feignLoggerLevel() = FULL
}
