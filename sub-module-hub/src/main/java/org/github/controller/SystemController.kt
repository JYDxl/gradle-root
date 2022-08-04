package org.github.controller

import org.github.service.ISystemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Validated
class SystemController {
  @Autowired
  private lateinit var systemService: ISystemService

  @PostMapping("/login")
  fun login() = systemService.login()

  @PostMapping("/logout")
  fun logout() = systemService.logout()

  @RequestMapping("/jsessionid")
  fun jsessionid() = systemService.jsessionid()

  @RequestMapping("/jwt")
  fun jwt() = systemService.jwt()
}
