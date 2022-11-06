package org.github.controller

import cn.hutool.core.bean.BeanUtil.trimStrFields
import org.github.web.module.index.LoginBo
import org.github.web.module.index.RegisterBo
import org.github.web.module.sys.menu.service.IIndexService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RequestMapping("/index")
@RestController
class IndexController {
  @Autowired
  private lateinit var indexService: IIndexService

  @PostMapping("login")
  fun login(@RequestBody bo: LoginBo) = indexService.login(trimStrFields(bo))

  @PostMapping("register")
  fun register(@Validated @RequestBody bo: RegisterBo) = indexService.register(trimStrFields(bo))
}
