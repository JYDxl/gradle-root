package org.github.module.file.common.dto.protocol

import org.github.module.file.common.dto.protocol.CMD.LOGIN_RES
import org.github.module.file.common.dto.protocol.protobuf.FileProto.LoginResProto

class LoginRes: CommonMsg<LoginResProto>() {
  init {
    cmd = LOGIN_RES
  }

  override fun toString(): String {
    return super.toString() + "success=${body.success}, message=${body.message}, "
  }
}
