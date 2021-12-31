package org.github.module.file.common.dto

import org.github.module.file.common.dto.CMD.LOGIN_REQ
import org.github.module.file.common.dto.protobuf.FileProto.LoginReqProto

class LoginReq: CommonMsg<LoginReqProto>() {
  init {
    cmd = LOGIN_REQ
  }

  override fun toString(): String {
    return super.toString() + "username=${body.username}, password=${body.password}, "
  }
}
