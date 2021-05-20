package org.github.shiro

interface User {
  val userId: Any

  val username: String

  val password: String

  val salt: String?

  var token: String?
}
