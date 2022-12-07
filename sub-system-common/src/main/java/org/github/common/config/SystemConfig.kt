package org.github.common.config

import org.github.core.logger.MethodInvokeLogger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SystemConfig {
  @Bean
  fun methodInvokeLogger() = MethodInvokeLogger()
}
