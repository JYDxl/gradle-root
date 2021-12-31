package org.github.module.file.common

import cn.hutool.core.io.unit.DataSize

val MAX_LENGTH = DataSize.parse("1MB").toBytes()

const val CMD_LENGTH = 1

const val LEN_LENGTH = 8

const val FILE_DOWNLOAD_RES_MSG_BODY_LENGTH = 4
