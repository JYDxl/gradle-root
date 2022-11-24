package org.github.service.impl

import cn.dev33.satoken.stp.StpInterface
import org.springframework.stereotype.Component

@Component
class SaRemoteImpl: StpInterface {
  override fun getPermissionList(loginId: Any?, loginType: String?): MutableList<String> {
    TODO("Not yet implemented")
  }

  override fun getRoleList(loginId: Any?, loginType: String?): MutableList<String> {
    TODO("Not yet implemented")
  }
}
