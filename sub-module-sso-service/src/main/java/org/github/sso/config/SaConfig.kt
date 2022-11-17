package org.github.sso.config

import org.github.sso.sa.SaImpl
import org.github.sso.sa.SaTokenConfigurer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SaConfig {
  @Bean
  fun saInterface() = SaImpl()

  @Bean
  fun saTokenConfigurer() = SaTokenConfigurer()
}
