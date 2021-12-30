package org.github.module.file.common.decoder

import org.github.module.file.common.MAX_LENGTH
import org.github.netty.decoder.LengthDecoder
import org.github.ops.log

class FrameDecoder: LengthDecoder(1, 8, MAX_LENGTH.toInt(), getLength = {buf, _, _ -> buf.getLong(1)}, log = FrameDecoder::class.log)
