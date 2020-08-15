package org.github.netty.decoder

import io.netty.buffer.Unpooled
import io.netty.channel.embedded.EmbeddedChannel
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.logging.LogLevel
import io.netty.handler.logging.LoggingHandler
import org.github.ops.requireNotNull
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class DefaultDelimiterDecoderTest {
  @Test
  fun decode() {
    val decoder = DefaultDelimiterDecoder(Int.MAX_VALUE, arrayOf(Unpooled.wrappedBuffer("\n".toByteArray()), Unpooled.wrappedBuffer("\r\n".toByteArray()), Unpooled.wrappedBuffer("\r".toByteArray())))
    val channel = EmbeddedChannel(LoggingHandler(LogLevel.TRACE), decoder, StringDecoder(Charsets.UTF_8))
    assertTrue(channel.writeInbound(Unpooled.wrappedBuffer("2333\n1234\r\nasm\nnico\r".toByteArray())))
    assertTrue(channel.finish())
    val msg1 = channel.readInbound<String>().requireNotNull
    assertEquals(msg1, "2333")
    val msg2 = channel.readInbound<String>().requireNotNull
    assertEquals(msg2, "1234")
    val msg3 = channel.readInbound<String>().requireNotNull
    assertEquals(msg3, "asm")
    val msg4 = channel.readInbound<String>().requireNotNull
    assertEquals(msg4, "nico")
    val msg5 = channel.readInbound<String>()
    assertNull(msg5)
  }
}
