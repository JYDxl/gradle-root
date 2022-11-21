package org.github.controller

import org.github.sso.bo.LoginBo
import org.github.sso.bo.RegisterBo
import org.github.sso.service.ISsoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RequestMapping("/index")
@RestController
class IndexController {
  @Autowired
  private lateinit var ssoService: ISsoService

  @PostMapping("login")
  fun login(@RequestBody bo: LoginBo) = ssoService.login(bo.apply {trim()})

  @PostMapping("register")
  fun register(@RequestBody bo: RegisterBo) = ssoService.register(bo.apply {trim()})

  @PostMapping("token")
  fun token(@RequestBody bo: LoginBo) = ssoService.token(bo.apply {trim()})
}
