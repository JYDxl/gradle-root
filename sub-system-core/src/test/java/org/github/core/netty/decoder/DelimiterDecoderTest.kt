package org.github.core.netty.decoder

import io.netty.buffer.Unpooled.wrappedBuffer
import io.netty.channel.embedded.EmbeddedChannel
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import kotlin.text.Charsets.UTF_8
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class DelimiterDecoderTest {
  @Test
  fun decode() {
    val decoder = DelimiterDecoder(arrayOf(wrappedBuffer("\n".toByteArray()), wrappedBuffer("\r\n".toByteArray()), wrappedBuffer("\r".toByteArray())))
    val channel = EmbeddedChannel(LoggingHandler(TRACE), decoder, StringDecoder(UTF_8))
    assertTrue(channel.writeInbound(wrappedBuffer("2333\n1234\r\nawsl\nnico\r".toByteArray())))
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
