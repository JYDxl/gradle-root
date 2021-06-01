package org.github.service.impl

import org.apache.shiro.SecurityUtils.getSubject
import org.apache.shiro.session.Session
import org.apache.shiro.subject.Subject
import org.github.exception.ParamsErrorException
import org.github.service.ISystemService
import org.github.shiro.*
import org.github.shiro.JWTUtil.sign
import org.github.spring.restful.json.JSONDataReturn
import org.github.spring.restful.json.JSONReturn
import org.springframework.beans.BeanUtils.copyProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SystemServiceImpl: ISystemService {
  @Autowired
  private lateinit var generator: PasswordGenerator

  override fun login(): JSONDataReturn<User> {
    val subject: Subject = getSubject()
    val user = subject.principal as User
    val info = user.javaClass.getConstructor().newInstance()
    copyProperties(user, info)
    val session: Session? = subject.getSession(false)
    info.token = session?.id.toString()
    return JSONDataReturn.of(info)
  }

  override fun token(): JSONDataReturn<String?> {
    val subject: Subject = getSubject()
    val session: Session? = subject.getSession(false)
    val token = session?.id?.toString()
    return JSONDataReturn.of(token)
  }

  override fun jwt(): JSONDataReturn<String> {
    val user = getSubject().principal as User
    val jwt = sign(user.username, user.password)
    return JSONDataReturn.of(jwt)
  }

  override fun jwt(login: JWTLogin): JSONDataReturn<String> {
    val username = login.username ?: throw ParamsErrorException("用户名不能为空")
    val password = login.password ?: throw ParamsErrorException("密码不能为空")
    val secret = generator.generate(password, username)
    val jwt = sign(username, secret)
    return JSONDataReturn.of(jwt)
  }

  override fun feign(): Token {
    val token = token().data
    val jwt = if (token.isNullOrBlank()) jwt().data else null
    return Token(token, jwt)
  }

  override fun logout(): JSONReturn {
    getSubject().logout()
    return JSONReturn().withRetMsg("退出成功")
  }
}
