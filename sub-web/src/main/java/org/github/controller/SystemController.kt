package org.github.controller

import org.apache.shiro.SecurityUtils.getSubject
import org.apache.shiro.session.Session
import org.apache.shiro.subject.Subject
import org.github.spring.restful.Returnable
import org.github.spring.restful.json.JSONDataReturn.of
import org.github.spring.restful.json.JSONReturn
import org.github.spring.restful.json.JSONReturn.warn
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/")
@Controller
class SystemController {
  @RequestMapping("public/login", "login")
  fun login(): Returnable {
    return of(getSubject()?.principal)
  }

  @RequestMapping("public/token")
  fun token(): Returnable {
    val subject: Subject = getSubject()
    val session: Session? = subject.getSession(false)
    return of(session?.id)
  }

  @RequestMapping("public/failure")
  fun failure(): Returnable {
    return warn().withRetMsg("用户名或密码错误")
  }

  @RequestMapping("public/unauthorized")
  fun unauthorized(): Returnable {
    return warn().withRetMsg("权限不足")
  }

  @RequestMapping("public/logout")
  fun logout(): Returnable {
    return JSONReturn().withRetMsg("退出成功")
  }
}
