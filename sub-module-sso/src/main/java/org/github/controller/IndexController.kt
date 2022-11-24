package org.github.controller

import org.github.sso.bo.RegisterBo
import org.github.sso.service.ISsoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RequestMapping("/index")
@RestController
class IndexController {
  @Autowired
  private lateinit var ssoService: ISsoService

  @PostMapping("register")
  fun register(@RequestBody bo: RegisterBo) = ssoService.register(bo.apply {trim()})
}
