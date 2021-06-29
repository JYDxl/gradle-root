package org.github.controller

import org.github.ops.trim
import org.github.service.IShiroService
import org.github.service.ISystemService
import org.github.shiro.WEBLogin
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@RestController
@Validated
class SystemController {
  @Autowired
  private lateinit var systemService: ISystemService

  @Autowired
  private lateinit var shiroService: IShiroService

  @GetMapping("/public/security/user/{username}")
  fun user(@PathVariable @NotBlank username: String) = shiroService.queryUser(username.trim())

  @GetMapping("/public/security/auth/{userId}")
  fun auth(@PathVariable @NotNull userId: Long) = shiroService.queryAuthorInfo(userId)

  @PostMapping("/login")
  fun login() = systemService.login()

  @PostMapping("/logout")
  fun logout() = systemService.logout()

  @RequestMapping("/jsessionid")
  fun jsessionid() = systemService.jsessionid()

  @RequestMapping("/jwt")
  fun jwt() = systemService.jwt()

  @PostMapping("/public/jwt")
  fun jwt(@RequestBody @Valid bo: WEBLogin) = systemService.jwt(bo.trim())
}
