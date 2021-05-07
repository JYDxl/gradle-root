package org.github.controller

import org.apache.shiro.SecurityUtils.getSubject
import org.apache.shiro.session.Session
import org.apache.shiro.subject.Subject
import org.github.spring.restful.Returnable
import org.github.spring.restful.json.JSONDataReturn.of
import org.github.web.model.dto.UserInfoDTO
import org.springframework.beans.BeanUtils.copyProperties
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/")
@RestController
class SystemController {
  @PostMapping( "login")
  fun login(): Returnable {
    val subject: Subject = getSubject()
    if (subject.principal==null)return of()
    val userInfo = UserInfoDTO()
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
}
