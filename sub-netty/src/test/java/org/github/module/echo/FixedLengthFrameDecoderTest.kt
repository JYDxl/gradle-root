package org.github.module.echo

import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled
import io.netty.channel.embedded.EmbeddedChannel
import io.netty.handler.logging.LoggingHandler
import org.github.module.echo.shaded.FixedLengthFrameDecoder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FixedLengthFrameDecoderTest {
  @Test
  fun test1() {
    val buf = Unpooled.wrappedBuffer(byteArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8))
    val input = buf.copy()!!
    val channel = EmbeddedChannel(LoggingHandler(), FixedLengthFrameDecoder(3))
    Assertions.assertTrue(channel.writeInbound(input))
    assert(channel.finish())

    val output1 = channel.readInbound<ByteBuf>()!!
    Assertions.assertEquals(buf.readSlice(3), output1)
    output1.release()

    val output2 = channel.readInbound<ByteBuf>()!!
    Assertions.assertEquals(buf.readSlice(3), output2)
    output2.release()

    val output3 = channel.readInbound<ByteBuf>()!!
    Assertions.assertEquals(buf.readSlice(3), output3)
    output3.release()

    val output4: ByteBuf? = channel.readInbound<ByteBuf>()
    Assertions.assertNull(output4)
    buf.release()
  }

  @Test
  fun test2() {
    val buf = Unpooled.wrappedBuffer(byteArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8))
    val input = buf.copy()!!
    val channel = EmbeddedChannel(LoggingHandler(), FixedLengthFrameDecoder(3))
    Assertions.assertFalse(channel.writeInbound(input.readBytes(2)))
    Assertions.assertTrue(channel.writeInbound(input.readBytes(7)))
    input.release()
    assert(channel.finish())

    val output1 = channel.readInbound<ByteBuf>()!!
    Assertions.assertEquals(buf.readSlice(3), output1)
    output1.release()

    val output2 = channel.readInbound<ByteBuf>()!!
    Assertions.assertEquals(buf.readSlice(3), output2)
    output2.release()

    val output3 = channel.readInbound<ByteBuf>()!!
    Assertions.assertEquals(buf.readSlice(3), output3)
    output3.release()

    val output4: ByteBuf? = channel.readInbound<ByteBuf>()
    Assertions.assertNull(output4)
    buf.release()
  }
}
