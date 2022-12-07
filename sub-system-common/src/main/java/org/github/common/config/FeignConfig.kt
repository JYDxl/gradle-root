package org.github.common.config

import feign.Logger.Level.FULL
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignConfig {
  @Bean
  fun feignLoggerLevel() = FULL
}
