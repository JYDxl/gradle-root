package org.github.common.service

import org.github.core.spring.restful.json.JSONDataReturn
import org.github.core.spring.restful.json.JSONReturn

interface ISystemService {
  fun login(): JSONDataReturn<String?>

  fun jsessionid(): JSONDataReturn<String?>

  fun jwt(): JSONDataReturn<String>

  fun logout(): JSONReturn
}
