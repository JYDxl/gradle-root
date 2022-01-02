package org.github.module.file.common.dto.protocol

import org.github.module.file.common.dto.protocol.CMD.HEART_BEAT_REQ
import org.github.module.file.common.dto.protocol.protobuf.FileProto.HeartBeatReqProto

class HeartBeatReq: CommonMsg<HeartBeatReqProto>() {
  init {
    cmd = HEART_BEAT_REQ
  }
}
