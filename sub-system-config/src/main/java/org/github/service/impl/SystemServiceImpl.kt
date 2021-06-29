package org.github.service.impl

import org.apache.shiro.authc.UsernamePasswordToken
import org.github.service.ISystemService
import org.github.shiro.*
import org.github.shiro.JWTUtil.sign
import org.github.shiro.ops.session
import org.github.shiro.ops.subject
import org.github.shiro.ops.user
import org.github.spring.restful.json.JSONDataReturn
import org.github.spring.restful.json.JSONReturn
import org.springframework.stereotype.Service

@Service
class SystemServiceImpl: ISystemService {
  override fun login(): JSONDataReturn<String?> {
    return jsessionid()
  }

  override fun jsessionid(): JSONDataReturn<String?> {
    val jsessionid = session?.id?.toString()
    return JSONDataReturn.of(jsessionid)
  }

  override fun jwt(): JSONDataReturn<String> {
    val jwt = sign(user.username, user.password)
    return JSONDataReturn.of(jwt)
  }

  override fun jwt(bo: WEBLogin): JSONDataReturn<String> {
    subject.login(UsernamePasswordToken(bo.username, bo.password, bo.isRememberMe, bo.host))
    return jwt()
  }

  override fun feign(): Token {
    val jsessionid = session?.id?.toString()
    val jwt = if (jsessionid.isNullOrBlank()) jwt().data else null
    return Token(jsessionid, jwt)
  }

  override fun logout(): JSONReturn {
    subject.logout()
    return JSONReturn().withRetMsg("退出成功")
  }
}
