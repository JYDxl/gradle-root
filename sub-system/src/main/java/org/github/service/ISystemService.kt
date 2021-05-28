package org.github.service

import org.github.shiro.JWTLogin
import org.github.shiro.Token
import org.github.shiro.User

interface ISystemService {
  fun login(): User

  fun token(): String?

  fun jwt(): String

  fun jwt(login: JWTLogin): String

  fun feign(): Token
}
