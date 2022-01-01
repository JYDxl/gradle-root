package org.github.module.file.common.dto.protocol

import org.github.module.file.common.dto.protocol.CMD.CHAT_RES
import org.github.module.file.common.dto.protocol.protobuf.FileProto.ChatResProto

class ChatRes: CommonMsg<ChatResProto>() {
  init {
    cmd = CHAT_RES
  }
}
