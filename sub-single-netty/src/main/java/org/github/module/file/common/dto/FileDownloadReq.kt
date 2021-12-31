package org.github.module.file.common.dto

import org.github.module.file.CommonMsg
import org.github.module.file.common.dto.CMD.FILE_DOWNLOAD_REQ
import org.github.module.file.common.dto.protobuf.FileProto.FileDownloadReqProto

class FileDownloadReq: CommonMsg<FileDownloadReqProto>() {
  init {
    cmd = FILE_DOWNLOAD_REQ
  }

  override fun desc(): String {
    return super.desc() + "path=${body.path}, "
  }
}
