package org.github.center.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import javax.annotation.Resource
import org.github.center.bo.LoginBo
import org.github.center.service.ICenterService
import org.github.core.spring.restful.Returnable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@Api("共通功能")
@RestController
@RequestMapping("/public/")
class PublicController {
  @Resource
  private lateinit var centerService: ICenterService

  @ApiOperation("共通功能-上传")
  @PostMapping("upload")
  fun upload(file: MultipartFile, repo: String): Returnable {
    return centerService.upload(file, repo)
  }

  @ApiOperation("共通功能-注册")
  @PostMapping("register")
  fun register(@RequestBody bo: LoginBo) = centerService.register(bo.apply {trim()})
}
