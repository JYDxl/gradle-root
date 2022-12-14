package org.github.center.service.impl

import com.alicp.jetcache.anno.Cached
import javax.annotation.Resource
import org.github.center.mapper.SaTokenMapper
import org.github.common.service.ISaTokenInterface
import org.github.core.CACHE_NAME_PERMISSION
import org.github.core.CACHE_TIMEOUT
import org.github.core.spring.ops.proxy
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

@Component
@Primary
class SaTokenRealImpl : ISaTokenInterface {
    @Resource
    private lateinit var saTokenMapper: SaTokenMapper

    override fun getPermissionList(loginId: Any, loginType: String): List<String> {
        val roleList = getRoleList(loginId, loginType)
        return roleList.flatMap { proxy.queryPermissionList(it, loginType) }.distinct()
    }

    override fun getRoleList(loginId: Any, loginType: String): List<String> {
        return saTokenMapper.getRoleList(loginId)
    }

    @Cached(name = CACHE_NAME_PERMISSION, expire = CACHE_TIMEOUT, key = "#roleId")
    fun queryPermissionList(roleId: Any, loginType: String): List<String> {
        return saTokenMapper.getPermissionList(roleId)
    }
}
