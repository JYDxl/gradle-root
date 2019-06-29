package org.github.echo

import io.netty.buffer.PooledByteBufAllocator
import io.netty.channel.embedded.EmbeddedChannel
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import org.github.ops.writeString
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.text.Charsets.UTF_8

class LengthDecoderWithPreCheckerTest {
  @Test
  fun testFrameHead() {
    val allocator = PooledByteBufAllocator()
    val buf = allocator.buffer()!!
    val input1 = "as1a"
    val input2 = "as1b"
    val input3 = "as1c"
    buf.writeString(input1)
    buf.writeString(input2)
    buf.writeString(input3)
    val checker = LengthDecoderWithPreChecker(maxFrameLength = 4, lengthFieldOffset = 2, lengthFieldLength = 1)
    val channel = EmbeddedChannel(LoggingHandler(TRACE), checker, StringDecoder(UTF_8))
    channel.writeInbound(buf)
    channel.finish()
    val output1 = channel.readInbound<String>()!!
    val output2 = channel.readInbound<String>()!!
    val output3 = channel.readInbound<String>()!!
    assertEquals(input1, output1)
    assertEquals(input2, output2)
    assertEquals(input3, output3)
  }
}
