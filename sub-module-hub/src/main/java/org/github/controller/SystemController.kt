package org.github.controller

import org.github.ops.trimStrFields
import org.github.service.IShiroService
import org.github.service.ISystemService
import org.github.shiro.JWTLogin
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class SystemController {
  @Autowired
  private lateinit var systemService: ISystemService

  @Autowired
  private lateinit var shiroService: IShiroService

  @GetMapping("/public/security/user/{username}")
  fun user(@PathVariable username: String) = shiroService.queryUser(username.trim())

  @GetMapping("/public/security/auth/{userId}")
  fun auth(@PathVariable userId: Long) = shiroService.queryAuthorInfo(userId)

  @PostMapping("/login")
  fun login() = systemService.login()

  @PostMapping("/logout")
  fun logout() = systemService.logout()

  @RequestMapping("/jsessionid")
  fun jsessionid() = systemService.jsessionid()

  @RequestMapping("/jwt")
  fun jwt() = systemService.jwt()

  @PostMapping("/public/jwt")
  fun jwt(@RequestBody login: JWTLogin) = systemService.jwt(login.trimStrFields())
}
