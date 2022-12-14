package org.github.common.service

import cn.dev33.satoken.stp.StpInterface
import com.alicp.jetcache.anno.Cached
import org.github.core.CACHE_NAME_ROLE
import org.github.core.CACHE_TIMEOUT

interface ISaTokenInterface : StpInterface {
    override fun getPermissionList(loginId: Any, loginType: String): List<String>

    @Cached(name = CACHE_NAME_ROLE, expire = CACHE_TIMEOUT, key = "#loginId")
    override fun getRoleList(loginId: Any, loginType: String): List<String>
}
