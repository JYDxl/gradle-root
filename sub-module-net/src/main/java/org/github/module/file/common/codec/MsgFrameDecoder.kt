package org.github.module.file.common.codec

import org.github.module.file.common.MAX_LENGTH
import org.github.netty.decoder.LengthDecoder

class MsgFrameDecoder: LengthDecoder(1, 8, MAX_LENGTH.toInt())
