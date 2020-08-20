package org.github.netty.decoder

import io.netty.channel.embedded.EmbeddedChannel
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.logging.LogLevel.*
import io.netty.handler.logging.LoggingHandler
import org.github.netty.ops.toByteBuf
import org.github.ops.requireNotNull
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.Int.Companion.MAX_VALUE
import kotlin.text.Charsets.UTF_8

internal class DefaultDelimiterDecoderTest {
  @Test
  fun decode() {
    val decoder = DefaultDelimiterDecoder(MAX_VALUE, arrayOf("\n".toByteBuf(), "\r\n".toByteBuf(), "\r".toByteBuf()))
    val channel = EmbeddedChannel(LoggingHandler(TRACE), decoder, StringDecoder(UTF_8))
    assertTrue(channel.writeInbound("2333\n1234\r\nawsl\nnico\r".toByteBuf()))
    assertTrue(channel.finish())
    val msg1 = channel.readInbound<String>().requireNotNull
    assertEquals(msg1, "2333")
    val msg2 = channel.readInbound<String>().requireNotNull
    assertEquals(msg2, "1234")
    val msg3 = channel.readInbound<String>().requireNotNull
    assertEquals(msg3, "awsl")
    val msg4 = channel.readInbound<String>().requireNotNull
    assertEquals(msg4, "nico")
    val msg5 = channel.readInbound<String>()
    assertNull(msg5)
  }
}
