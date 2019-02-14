package org.github.config

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TomcatConfig {
  @Bean
  fun tomcatServletWebServerFactory() = TomcatServletWebServerFactory().apply { setProtocol("org.apache.coyote.http11.Http11AprProtocol") }
}
