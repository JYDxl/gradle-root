package org.github.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "org.github.security")
class SecurityProperties {
  var hashAlgorithm = "SHA-256"
  var hashIterations = 2
}
