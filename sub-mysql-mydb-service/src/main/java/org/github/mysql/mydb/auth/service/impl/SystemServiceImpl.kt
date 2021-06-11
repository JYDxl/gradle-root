package org.github.mysql.mydb.auth.service.impl

import org.github.exception.ParamsErrorException
import org.github.mysql.mydb.auth.service.ISystemService
import org.github.shiro.*
import org.github.shiro.JWTUtil.sign
import org.github.shiro.ops.session
import org.github.shiro.ops.subject
import org.github.shiro.ops.user
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
    val info = user.javaClass.getConstructor().newInstance()
    copyProperties(user, info)
    info.jsessionid = session?.id?.toString()
    return JSONDataReturn.of(info)
  }

  override fun jsessionid(): JSONDataReturn<String?> {
    val jsessionid = session?.id?.toString()
    return JSONDataReturn.of(jsessionid)
  }

  override fun jwt(): JSONDataReturn<String> {
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
    val jsessionid = session?.id?.toString()
    val jwt = if (jsessionid.isNullOrBlank()) jwt().data else null
    return Token(jsessionid, jwt)
  }

  override fun logout(): JSONReturn {
    subject.logout()
    return JSONReturn().withRetMsg("退出成功")
  }
}
