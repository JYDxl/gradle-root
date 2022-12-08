package org.github.common.service.impl

import cn.dev33.satoken.stp.StpUtil.getTokenValue
import org.github.center.bo.PermissionsBo
import org.github.center.bo.RolesBo
import org.github.center.feign.ICenterServerAPI
import org.github.common.service.ISaInterface
import org.springframework.stereotype.Component
import javax.annotation.Resource

@Component
class SaRemoteImpl: ISaInterface {
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
