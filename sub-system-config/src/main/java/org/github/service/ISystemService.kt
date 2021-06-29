package org.github.service

import org.github.shiro.Token
import org.github.shiro.WEBLogin
import org.github.spring.restful.json.JSONDataReturn
import org.github.spring.restful.json.JSONReturn

interface ISystemService {
  fun login(): JSONDataReturn<String?>

  fun jsessionid(): JSONDataReturn<String?>

  fun jwt(): JSONDataReturn<String>

  fun jwt(bo: WEBLogin): JSONDataReturn<String>

  fun feign(): Token

  fun logout(): JSONReturn
}
