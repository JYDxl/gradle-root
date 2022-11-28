package org.github.web.controller

import org.github.mysql.web.base.entity.AclRoleEntity
import org.github.mysql.web.base.service.IAclRoleService
import org.github.spring.restful.Returnable
import org.github.web.Views.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/role/")
class RoleController {
  @Autowired
  private lateinit var aclRoleService: IAclRoleService

  @GetMapping
  fun index(map: MutableMap<String, Any>): Returnable {
    val list: MutableList<AclRoleEntity> = aclRoleService.list()
    map["list"] = list
    return ROLE
  }
}
