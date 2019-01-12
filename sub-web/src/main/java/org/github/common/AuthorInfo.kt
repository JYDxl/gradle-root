package org.github.common

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix = "info.author")
@Component
class AuthorInfo {
  var username = "root"

  var password = "root"
}
