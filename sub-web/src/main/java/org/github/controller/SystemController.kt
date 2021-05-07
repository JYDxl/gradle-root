package org.github.controller

import org.apache.shiro.SecurityUtils.getSubject
import org.apache.shiro.session.Session
import org.apache.shiro.subject.Subject
import org.github.exception.ParamsErrorException
import org.github.ops.log
import org.github.spring.restful.Returnable
import org.github.spring.restful.json.JSONDataReturn.of
import org.github.system.shiro.JWTUtil.sign
import org.github.system.shiro.PasswordGenerator
import org.github.web.model.dto.UserInfoDTO
import org.github.web.model.system.JWTLogin
import org.springframework.beans.BeanUtils.copyProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/")
@RestController
class SystemController {
  private val log = SystemController::class.log

  @Autowired
  private lateinit var generator: PasswordGenerator

  @PostMapping( "login")
  fun login(): Returnable {
    val userInfo = UserInfoDTO()
    val subject: Subject = getSubject()
    copyProperties(subject.principal, userInfo)
    val session: Session? = subject.getSession(false)
    userInfo.sessionId = session?.id.toString()
    return of(userInfo)
  }

  @RequestMapping("public/token")
  fun token(): Returnable {
    val subject: Subject = getSubject()
    val session: Session? = subject.getSession(false)
    return of(session?.id)
  }

  @PostMapping("public/jwt")
  fun jwt(jwt: JWTLogin): Returnable {
    val username = jwt.username ?: throw ParamsErrorException("用户名不能为空")
    val password = jwt.password ?: throw ParamsErrorException("密码不能为空")
    val secret = generator.generate(password, username)
    val token = sign(username, secret)
    return of(token)
  }
}
