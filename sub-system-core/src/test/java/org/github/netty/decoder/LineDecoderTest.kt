package org.github.netty.decoder

import io.netty.buffer.Unpooled.wrappedBuffer
import io.netty.channel.embedded.EmbeddedChannel
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.Int.Companion.MAX_VALUE
import kotlin.text.Charsets.UTF_8

internal class LineDecoderTest {
  @Test
  fun decode() {
    val decoder = LineDecoder(MAX_VALUE)
    val channel = EmbeddedChannel(LoggingHandler(TRACE), decoder, StringDecoder(UTF_8))
    assertTrue(channel.writeInbound(wrappedBuffer("2333\n1234\r\nawsl\r\nnico\n".toByteArray())))
    assertTrue(channel.finish())
    val msg1: String = channel.readInbound()
    assertEquals(msg1, "2333")
    val msg2: String = channel.readInbound()
    assertEquals(msg2, "1234")
    val msg3: String = channel.readInbound()
    assertEquals(msg3, "awsl")
    val msg4: String = channel.readInbound()
    assertEquals(msg4, "nico")
    val msg5: String? = channel.readInbound<String>()
    assertNull(msg5)
  }
}