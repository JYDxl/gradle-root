package org.github.center.controller

import org.github.center.bo.RegisterBo
import org.github.center.service.ICenterService
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource

@RequestMapping("/index")
@RestController
class IndexController {
  @Resource
  private lateinit var centerService: ICenterService

  @PostMapping("register")
  fun register(@RequestBody bo: RegisterBo) = centerService.register(bo.apply {trim()})
}
