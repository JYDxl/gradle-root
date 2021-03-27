package org.github.netty

import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled.copiedBuffer
import io.netty.buffer.Unpooled.wrappedBuffer
import io.netty.channel.embedded.EmbeddedChannel
import io.netty.handler.codec.FixedLengthFrameDecoder
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.text.Charsets.UTF_8

class FixedLengthFrameDecoderTest {
  @Test
  fun test() {
    val channel = EmbeddedChannel(LoggingHandler(TRACE), FixedLengthFrameDecoder(3), StringDecoder(UTF_8))
    val head = copiedBuffer("01", UTF_8)
    assertFalse(channel.writeInbound(head))
    val tail = copiedBuffer("2345678", UTF_8)
    assertTrue(channel.writeInbound(tail))
    assertTrue(channel.finish())
    val out1 = channel.readInbound<String>()
    val out2 = channel.readInbound<String>()
    val out3 = channel.readInbound<String>()
    assertEquals("012", out1)
    assertEquals("345", out2)
    assertEquals("678", out3)
  }

  @Test
  fun testFramesDecoded() {
    val buf = wrappedBuffer(byteArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8))
    val input = buf.duplicate()
    val channel = EmbeddedChannel(LoggingHandler(TRACE), FixedLengthFrameDecoder(3))
    assertTrue(channel.writeInbound(input.retain()))
    input.release()
    assertTrue(channel.finish())
    val out1 = requireNotNull(channel.readInbound<ByteBuf>())
    val out2 = requireNotNull(channel.readInbound<ByteBuf>())
    val out3 = requireNotNull(channel.readInbound<ByteBuf>())
    assertNull(channel.readInbound())
    assertEquals(buf.readSlice(3), out1)
    out1.release()
    assertEquals(buf.readSlice(3), out2)
    out2.release()
    assertEquals(buf.readSlice(3), out3)
    out3.release()
  }
}
