package org.github.module.file.common.dto.protocol

import org.github.module.file.common.dto.protocol.CMD.LOGIN_REQ
import org.github.module.file.common.dto.protocol.protobuf.FileProto.LoginReqProto

class LoginReq: CommonMsg<LoginReqProto>() {
  init {
    cmd = LOGIN_REQ
  }
}
