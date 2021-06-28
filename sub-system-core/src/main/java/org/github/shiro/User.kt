package org.github.shiro

interface User {
  val id: Long
  val username: String
  val password: String
  val salt: String?
}
