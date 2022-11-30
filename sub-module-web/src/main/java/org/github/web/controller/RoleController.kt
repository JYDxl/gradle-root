package org.github.web.controller

import org.github.base.PageParam
import org.github.mysql.web.base.entity.AclRoleEntity
import org.github.spring.restful.Returnable
import org.github.spring.restful.view.VIEW
import org.github.web.Views.*
import org.github.web.model.bo.RoleSaveBo
import org.github.web.service.IRoleService
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.annotation.Resource


@Controller
@RequestMapping("/role/")
class RoleController {
  @Resource
  lateinit var roleService: IRoleService

  @GetMapping
  fun index(bo: PageParam, map: MutableMap<String, Any>): Returnable {
    val list = roleService.all(bo)
    map["list"] = list
    return ROLE
  }

  @GetMapping("create")
  fun createView() = ROLE_CREATE

  @PostMapping("save")
  fun save(bo: RoleSaveBo): Returnable {
    roleService.save(bo.apply {trim()})
    return SUCCESS
  }

  @GetMapping("/edit/{id}")
  fun edit(model: ModelMap, @PathVariable id: String): Returnable {
    val role = roleService.getById(id)
    model.addAttribute("role", role)
    return ROLE_EDIT
  }

  @PostMapping("/update")
  fun update(bo: AclRoleEntity): Returnable {
    roleService.update(bo)
    return SUCCESS
  }

  @GetMapping("/delete/{id}")
  fun delete(@PathVariable id: String): Returnable {
    roleService.delete(id)
    return VIEW {"redirect:/role/"}
  }
}
