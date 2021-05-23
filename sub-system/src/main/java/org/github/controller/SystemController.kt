package org.github.controller

import org.github.ops.log
import org.github.service.ISystemService
import org.github.shiro.JWTLogin
import org.github.shiro.User
import org.github.spring.restful.json.JSONDataReturn
import org.github.spring.restful.json.JSONDataReturn.of
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

  @PostMapping("login")
  fun login(): JSONDataReturn<User> = of(systemService.login())

  @GetMapping("login")
  fun page() = VIEW {"login"}

  @RequestMapping("/token")
  fun token() = of(systemService.token())

  @RequestMapping("/jwt")
  fun refresh(): JSONDataReturn<String> = of(systemService.jwt())

  @PostMapping("public/jwt")
  fun jwt(@RequestBody jwt: JWTLogin): JSONDataReturn<String> = of(systemService.jwt(jwt))
}
