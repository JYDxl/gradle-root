package org.github.center.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import javax.annotation.Resource
import org.github.center.service.ICenterService
import org.github.core.spring.restful.Returnable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api("权限相关")
@RequestMapping("/auth/")
@RestController
class AuthController {
  @Resource
  private lateinit var centerService: ICenterService

  @ApiOperation("权限相关-刷新token")
  @PostMapping("fresh")
  fun refresh(): Returnable {
    return centerService.refresh()
  }
}
