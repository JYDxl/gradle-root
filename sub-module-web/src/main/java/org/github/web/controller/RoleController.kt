package org.github.web.controller

import org.github.spring.restful.Returnable
import org.github.web.Views.*
import org.github.web.model.bo.RoleSaveBo
import org.github.web.service.IRoleService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.annotation.Resource

@Controller
@RequestMapping("/role/")
class RoleController {
  @Resource
  private lateinit var roleService: IRoleService

  @GetMapping
  fun index(map: MutableMap<String, Any>): Returnable {
    val list = roleService.all()
    map["list"] = list
    return ROLE
  }

  @GetMapping("create")
  fun createView() = ROLE_CREATE

  @PostMapping("save")
  fun save(bo: RoleSaveBo) = roleService.save(bo.apply {trim()})
}
