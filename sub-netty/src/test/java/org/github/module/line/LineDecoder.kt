package org.github.module.line

import org.github.ops.log
import org.slf4j.Logger

class LineDecoder(maxFrameLength: Int, stripDelimiter: Boolean = true, failFast: Boolean = true): org.github.netty.LineDecoder(maxFrameLength, stripDelimiter, failFast) {
  override val logger: Logger = log

  companion object {
    /** log. */
    private val log = LineDecoder::class.log
  }
}
