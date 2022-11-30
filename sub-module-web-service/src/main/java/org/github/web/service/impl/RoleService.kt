package org.github.web.service.impl

import org.github.mysql.web.base.entity.AclRoleEntity
import org.github.mysql.web.base.service.IAclRoleService
import org.github.service.ICommonService
import org.github.spring.restful.json.JSONReturn
import org.github.web.model.bo.RoleSaveBo
import org.github.web.model.vo.RoleIndexVo
import org.github.web.service.IRoleService
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import javax.annotation.Resource

@Validated
@Service
class RoleService: IRoleService {
  @Resource
  private lateinit var aclRoleService: IAclRoleService

  @Resource
  private lateinit var commonService: ICommonService

  override fun save(bo: RoleSaveBo): JSONReturn {
    aclRoleService.saveOrUpdate(bo)
    return JSONReturn.ok()
  }

  override fun all(): List<RoleIndexVo> {
    val list: List<AclRoleEntity> = aclRoleService.list()
    return commonService.transCode(list, RoleIndexVo::class.java)
  }
}
