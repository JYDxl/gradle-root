package org.github.center.service.impl

import com.alicp.jetcache.anno.CacheType
import com.alicp.jetcache.anno.Cached
import org.github.core.CACHE_NAME_PERMISSION
import org.github.core.CACHE_TIMEOUT
import org.github.common.service.ISaInterface
import org.github.core.spring.ops.proxy
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

@Component
@Primary
class SaRealImpl: ISaInterface {
  override fun getPermissionList(username: Any, loginType: String): List<String> {
    val roleList = getRoleList(username, loginType)
    return roleList.flatMap {proxy.roleToPermissions(it, loginType)}.distinct()
  }

  override fun getRoleList(username: Any, loginType: String): List<String> {
    TODO()
  }

  @Cached(name = CACHE_NAME_PERMISSION, expire = CACHE_TIMEOUT, cacheType = CacheType.BOTH)
  fun roleToPermissions(role: Any, loginType: String): List<String> {
    TODO()
  }
}
