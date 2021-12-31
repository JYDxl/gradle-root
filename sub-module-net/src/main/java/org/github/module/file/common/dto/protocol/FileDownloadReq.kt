package org.github.module.file.common.dto.protocol

import org.github.module.file.common.dto.protocol.CMD.FILE_DOWNLOAD_REQ
import org.github.module.file.common.dto.protocol.protobuf.FileProto.FileDownloadReqProto

class FileDownloadReq: CommonMsg<FileDownloadReqProto>() {
  init {
    cmd = FILE_DOWNLOAD_REQ
  }

  override fun toString(): String {
    return super.toString() + "path=${body.path}, "
  }
}
