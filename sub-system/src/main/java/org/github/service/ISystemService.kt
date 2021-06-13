package org.github.service

import org.github.shiro.JWTLogin
import org.github.shiro.Token
import org.github.spring.restful.json.JSONDataReturn
import org.github.spring.restful.json.JSONReturn

interface ISystemService {
  fun login(): JSONDataReturn<String?>

  fun jsessionid(): JSONDataReturn<String?>

  fun jwt(): JSONDataReturn<String>

  fun jwt(login: JWTLogin): JSONDataReturn<String>

  fun feign(): Token

  fun logout(): JSONReturn
}
