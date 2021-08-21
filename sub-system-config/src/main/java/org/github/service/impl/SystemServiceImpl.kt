package org.github.service.impl

import org.apache.shiro.authc.UsernamePasswordToken
import org.github.service.ISystemService
import org.github.shiro.JWTUtil.sign
import org.github.shiro.Token
import org.github.shiro.User
import org.github.shiro.WEBLogin
import org.github.shiro.WEBRealm
import org.github.shiro.ops.session
import org.github.shiro.ops.subject
import org.github.shiro.ops.user
import org.github.spring.ops.webAppCtx
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
    val user = webAppCtx.getBean(WEBRealm::class.java).getAuthenticationInfo(UsernamePasswordToken(bo.username, bo.password)).principals.primaryPrincipal as User
    val jwt = sign(user.username, user.password)
    return JSONDataReturn.of(jwt)
  }

  override fun feign(): Token {
    val jsessionid = session?.id?.toString()
    val jwt = if (jsessionid.isNullOrBlank()) jwt().data else null
    return Token(jsessionid, jwt)
  }

  override fun logout(): JSONReturn {
    subject.logout()
    return JSONReturn()
  }
}
