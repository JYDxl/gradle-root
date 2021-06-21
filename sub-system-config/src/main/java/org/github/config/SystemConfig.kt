package org.github.config

import org.github.logger.MethodInvokeLogger
import org.github.spring.bootstrap.AppCtxHolder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SystemConfig {
  @Bean
  fun methodInvokeLogger() = MethodInvokeLogger()

  @Bean
  fun appCtxHolder() = AppCtxHolder()
}
