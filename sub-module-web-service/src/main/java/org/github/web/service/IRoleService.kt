package org.github.web.service

import org.github.spring.restful.json.JSONReturn
import org.github.web.model.bo.RoleSaveBo
import org.github.web.model.vo.RoleIndexVo
import javax.validation.Valid

interface IRoleService {
  fun save(@Valid bo: RoleSaveBo): JSONReturn

  fun all(): List<RoleIndexVo>
}
