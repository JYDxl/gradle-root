package org.github.center.service.impl

import com.alicp.jetcache.anno.CacheType
import com.alicp.jetcache.anno.Cached
import org.github.CACHE_NAME_PERMISSION
import org.github.CACHE_TIMEOUT
import org.github.mysql.sccore.base.entity.SysRoleEntity
import org.github.mysql.sccore.base.entity.SysUserEntity
import org.github.mysql.sccore.base.entity.SysUserRoleEntity
import org.github.mysql.sccore.base.service.ISysRoleService
import org.github.mysql.sccore.base.service.ISysUserRoleService
import org.github.mysql.sccore.base.service.ISysUserService
import org.github.service.SaInterface
import org.github.spring.ops.proxy
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import javax.annotation.Resource

@Component
@Primary
class SaRealImpl: SaInterface {
  @Resource
  private lateinit var sysUserService: ISysUserService

  @Resource
  private lateinit var sysUserRoleService: ISysUserRoleService

  @Resource
  private lateinit var sysRoleService: ISysRoleService

  override fun getPermissionList(username: Any, loginType: String): List<String> {
    val roleList = getRoleList(username, loginType)
    return roleList.flatMap {proxy.roleToPermissions(it, loginType)}.distinct()
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

  @Cached(name = CACHE_NAME_PERMISSION, expire = CACHE_TIMEOUT, cacheType = CacheType.BOTH)
  fun roleToPermissions(role: Any, loginType: String): List<String> {
    TODO()
  }
}
