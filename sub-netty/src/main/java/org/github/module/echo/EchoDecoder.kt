package org.github.module.echo

import org.github.netty.LineDecoder
import org.github.ops.log
import org.slf4j.Logger

class EchoDecoder(maxFrameLength: Int, stripDelimiter: Boolean = true, failFast: Boolean = true): LineDecoder(maxFrameLength, stripDelimiter, failFast) {
  override val logger: Logger = log

  companion object {
    /** log. */
    private val log = EchoDecoder::class.log
  }
}
