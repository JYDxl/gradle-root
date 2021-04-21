package org.github.config

import org.github.system.MethodInvokeLogger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SystemConfig {
  @Bean
  fun methodInvokeLogger() = MethodInvokeLogger()
}
