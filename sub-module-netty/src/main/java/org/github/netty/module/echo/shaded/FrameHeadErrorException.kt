package org.github.netty.module.echo.shaded

import io.netty.handler.codec.DecoderException

class FrameHeadErrorException(msg: String): DecoderException(msg)
