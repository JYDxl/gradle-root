package org.github.center.controller

import javax.annotation.Resource
import org.github.center.bo.RegisterBo
import org.github.center.service.ICenterService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/index")
@RestController
class IndexController {
  @Resource
  private lateinit var centerService: ICenterService

  @PostMapping("register")
  fun register(@RequestBody bo: RegisterBo) = centerService.register(bo.apply {trim()})
}
