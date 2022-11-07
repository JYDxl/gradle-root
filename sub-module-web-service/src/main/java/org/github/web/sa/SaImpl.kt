package org.github.web.sa

import cn.dev33.satoken.stp.StpInterface
import org.github.mysql.sccore.base.entity.SysRoleEntity
import org.github.mysql.sccore.base.entity.SysUserEntity
import org.github.mysql.sccore.base.entity.SysUserRoleEntity
import org.github.mysql.sccore.base.service.ISysRoleService
import org.github.mysql.sccore.base.service.ISysUserRoleService
import org.github.mysql.sccore.base.service.ISysUserService
import javax.annotation.Resource

class SaImpl: StpInterface {
  @Resource
  private lateinit var sysUserService: ISysUserService

  @Resource
  private lateinit var sysUserRoleService: ISysUserRoleService

  @Resource
  private lateinit var sysRoleService: ISysRoleService

  override fun getPermissionList(username: Any, loginType: String): List<String> {
    TODO()
  }

  override fun getRoleList(username: Any, loginType: String): List<String> {
    val user = sysUserService.ktQuery().eq(SysUserEntity::userName, username).one()!!
    val roleIds = sysUserRoleService.ktQuery().eq(SysUserRoleEntity::userId, user.id).select(SysUserRoleEntity::roleId).list().map {it.id!!}
    if (roleIds.isEmpty()) {
      return emptyList()
    }
    val roleCodeSet = sysRoleService.ktQuery().`in`(SysRoleEntity::id, roleIds).select(SysRoleEntity::roleCode).list().mapTo(hashSetOf()) {it.roleCode!!}
    return roleCodeSet.toList()
  }
}
