package org.github.module.file.common.dto.protocol

import org.github.module.file.common.dto.protocol.CMD.CHAT_REQ
import org.github.module.file.common.dto.protocol.protobuf.FileProto.ChatReqProto

class ChatReq: CommonMsg<ChatReqProto>() {
  init {
    cmd = CHAT_REQ
  }
}
