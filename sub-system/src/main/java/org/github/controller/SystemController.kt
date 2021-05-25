package org.github.controller

import org.github.ops.log
import org.github.service.ISystemService
import org.github.shiro.JWTLogin
import org.github.spring.restful.Returnable
import org.github.spring.restful.view.VIEW
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/")
@Controller
class SystemController {
  private val log = SystemController::class.log

  @Autowired
  private lateinit var systemService: ISystemService

  @GetMapping("login")
  fun page(): Returnable = VIEW {"login"}

  @PostMapping("login")
  fun login(): Returnable = systemService.login()

  @RequestMapping("/token")
  fun token(): Returnable = systemService.token()

  @RequestMapping("/jwt")
  fun jwt(): Returnable = systemService.jwt()

  @PostMapping("public/jwt")
  fun jwt(@RequestBody login: JWTLogin): Returnable = systemService.jwt(login)
}
