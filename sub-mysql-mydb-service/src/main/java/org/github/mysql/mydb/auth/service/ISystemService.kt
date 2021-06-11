package org.github.mysql.mydb.auth.service

import org.github.shiro.JWTLogin
import org.github.shiro.Token
import org.github.shiro.User
import org.github.spring.restful.json.JSONDataReturn
import org.github.spring.restful.json.JSONReturn

interface ISystemService {
  fun login(): JSONDataReturn<User>

  fun jsessionid(): JSONDataReturn<String?>

  fun jwt(): JSONDataReturn<String>

  fun jwt(login: JWTLogin): JSONDataReturn<String>

  fun feign(): Token

  fun logout(): JSONReturn
}
