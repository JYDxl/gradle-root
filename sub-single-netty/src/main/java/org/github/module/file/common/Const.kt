package org.github.module.file.common

import cn.hutool.core.io.unit.DataSize

val MAX_LENGTH = DataSize.parse("1MB").toBytes()

const val CMD_LENGTH = 1

const val LEN_LENGTH = 8

const val OFFSET_LENGTH = 8

const val LENGTH_LENGTH = 8

const val FILE_RES_LENGTH = CMD_LENGTH + LEN_LENGTH + OFFSET_LENGTH + LENGTH_LENGTH

val MAX_FILE_SEGMENT_LENGTH = MAX_LENGTH - FILE_RES_LENGTH
