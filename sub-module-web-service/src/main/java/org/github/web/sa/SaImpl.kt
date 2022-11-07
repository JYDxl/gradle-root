package org.github.web.sa

import cn.dev33.satoken.stp.StpInterface

class SaImpl: StpInterface {
  override fun getPermissionList(loginId: Any, loginType: String): MutableList<String> {
    TODO("Not yet implemented")
  }

  override fun getRoleList(loginId: Any, loginType: String): MutableList<String> {
    TODO("Not yet implemented")
  }
}
