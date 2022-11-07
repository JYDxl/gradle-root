package org.github.web.config

import org.github.web.sa.SaImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SaConfig {
  @Bean
  fun saInterface() = SaImpl()
}
