package org.github.controller

import org.github.ops.trimStrFields
import org.github.service.IShiroService
import org.github.service.ISystemService
import org.github.shiro.JWTLogin
import org.github.spring.restful.Returnable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class SystemController {
  @Autowired
  private lateinit var systemService: ISystemService

  @Autowired
  private lateinit var shiroService: IShiroService

  @GetMapping("/public/security/user/{username}")
  fun user(@PathVariable username: String): Returnable {
    return shiroService.queryUser(username.trim())
  }

  @GetMapping("/public/security/auth/{userId}")
  fun auth(@PathVariable userId: String): Returnable {
    return shiroService.queryAuthorInfo(userId.trim())
  }

  @PostMapping("/login")
  fun login(): Returnable {
    return systemService.login()
  }

  @PostMapping("/logout")
  fun logout(): Returnable {
    return systemService.logout()
  }

  @RequestMapping("/jsessionid")
  fun jsessionid(): Returnable {
    return systemService.jsessionid()
  }

  @RequestMapping("/jwt")
  fun jwt(): Returnable {
    return systemService.jwt()
  }

  @PostMapping("/public/jwt")
  fun jwt(@RequestBody login: JWTLogin): Returnable {
    return systemService.jwt(login.trimStrFields())
  }
}
