package org.github.web.controller

import org.github.base.model.bo.UserBO
import org.github.ops.error
import org.github.ops.info
import org.github.ops.log
import org.github.spring.restful.Returnable
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
}
