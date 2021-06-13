package org.github.shiro

interface User {
  val userId: String
  val username: String
  val password: String
  val salt: String?
}
