package org.github.shiro.controller

import org.github.ops.log
import org.github.service.IShiroService
import org.github.service.ISystemService
import org.github.shiro.JWTLogin
import org.github.spring.restful.Returnable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class SystemController {
  private val log = SystemController::class.log

  @Autowired
  private lateinit var systemService: ISystemService

  @Autowired
  private lateinit var shiroService: IShiroService

  @GetMapping("/security/user/{username}")
  fun user(@PathVariable username: String): Returnable {
    return shiroService.queryUser(username)
  }

  @GetMapping("/security/auth/{userId}")
  fun auth(@PathVariable userId: String): Returnable {
    return shiroService.queryAuthorInfo(userId)
  }

  @PostMapping("/login")
  fun login(): Returnable {
    return systemService.login()
  }

  @RequestMapping("/token")
  fun token(): Returnable {
    return systemService.token()
  }

  @RequestMapping("/jwt")
  fun jwt(): Returnable {
    return systemService.jwt()
  }

  @PostMapping("/public/jwt")
  fun jwt(@RequestBody login: JWTLogin): Returnable {
    return systemService.jwt(login)
  }
}
