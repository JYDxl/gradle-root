package org.github.module.echo.shaded

import io.netty.handler.codec.DecoderException

class FrameHeadErrorException(msg: String): DecoderException(msg)
