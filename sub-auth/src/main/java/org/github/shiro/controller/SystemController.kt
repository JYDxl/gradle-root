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

  @PostMapping("/logout")
  fun logout(): Returnable {
    //TODO 待实现，待测试 首先调用logout，其次清理shiro的cache，包括用户和权限(权限和用户cache名配置到文件中，feign()调用的错误统一包装为登录过期)
    return Returnable.of()
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
