package org.github.common.service.impl

import cn.dev33.satoken.stp.StpUtil.getTokenValue
import javax.annotation.Resource
import org.github.center.bo.PermissionsBo
import org.github.center.bo.RolesBo
import org.github.center.feign.ICenterServerAPI
import org.github.common.service.ISaTokenInterface
import org.springframework.stereotype.Component

@Component
class SaTokenRemoteImpl: ISaTokenInterface {
  @Resource
  private lateinit var centerServerAPI: ICenterServerAPI

  override fun getPermissionList(loginId: Any?, loginType: String?): List<String> {
    val token = getTokenValue()!!
    val bo = PermissionsBo(loginId, loginType)
    val result = centerServerAPI.getPermissionList(token, bo)
    result.throwIfFailed()
    return result.data.toList()
  }

  override fun getRoleList(loginId: Any?, loginType: String?): List<String> {
    val token = getTokenValue()!!
    val bo = RolesBo(loginId, loginType)
    val result = centerServerAPI.getRoleList(token, bo)
    result.throwIfFailed()
    return result.data.toList()
  }
}
