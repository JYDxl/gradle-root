package org.github.module.line

import io.netty.buffer.ByteBuf
import io.netty.handler.codec.Delimiters.lineDelimiter
import org.github.netty.DelimiterDecoder
import org.github.ops.log
import org.slf4j.Logger

class LineDecoder(maxFrameLength: Int, delimiters: Array<ByteBuf> = lineDelimiter(), stripDelimiter: Boolean = true, failFast: Boolean = true, override val log: Logger = LineDecoder::class.log): DelimiterDecoder(maxFrameLength, delimiters, stripDelimiter, failFast)
