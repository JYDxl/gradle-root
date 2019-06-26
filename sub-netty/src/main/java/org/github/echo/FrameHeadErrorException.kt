package org.github.echo

import io.netty.handler.codec.DecoderException

class FrameHeadErrorException(msg: String) : DecoderException(msg)
