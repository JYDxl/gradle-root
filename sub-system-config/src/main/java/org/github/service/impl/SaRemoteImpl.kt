package org.github.service.impl

import cn.dev33.satoken.stp.StpInterface
import cn.dev33.satoken.stp.StpUtil.getTokenValue
import org.github.sso.bo.PermissionsBo
import org.github.sso.bo.RolesBo
import org.github.sso.feign.ISsoServerAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class SaRemoteImpl: StpInterface {
  @Autowired
  private lateinit var ssoServerAPI: ISsoServerAPI

  override fun getPermissionList(loginId: Any?, loginType: String?): List<String> {
    val token = getTokenValue()!!
    val bo = PermissionsBo(loginId, loginType)
    val result = ssoServerAPI.getPermissionList(token, bo)
    result.throwIfFailed()
    return result.data.toList()
  }

  override fun getRoleList(loginId: Any?, loginType: String?): List<String> {
    val token = getTokenValue()!!
    val bo = RolesBo(loginId, loginType)
    val result = ssoServerAPI.getRoleList(token, bo)
    result.throwIfFailed()
    return result.data.toList()
  }
}
