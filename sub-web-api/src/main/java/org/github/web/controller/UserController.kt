package org.github.web.controller

import org.apache.shiro.SecurityUtils
import org.apache.shiro.authc.UsernamePasswordToken
import org.github.base.entity.TbUserEntity
import org.github.base.model.bo.UserBO
import org.github.ops.error
import org.github.ops.info
import org.github.ops.log
import org.github.spring.restful.Returnable
import org.github.spring.restful.json.JSONDataReturn
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import javax.validation.Valid

@Controller
@RequestMapping("/user/")
class UserController {
  private val log = UserController::class.log

  @PostMapping("register")
  fun register(@Valid @RequestBody user: UserBO, check: BindingResult): Returnable {
    log.info {user}
    if (check.hasErrors()) {
      log.error {check.allErrors.first()}
    }
    return Returnable.nil()
  }

  @PostMapping("login")
  fun login(@RequestBody user: TbUserEntity): Returnable {
    val token = UsernamePasswordToken(user.userName, user.password)
    val subject = SecurityUtils.getSubject()
    subject.login(token)
    subject.isAuthenticated
    subject.hasRole("admin")
    return JSONDataReturn.of(true)
  }
}
