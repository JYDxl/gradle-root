package org.github.module.echo

import io.netty.buffer.Unpooled
import io.netty.channel.embedded.EmbeddedChannel
import io.netty.handler.logging.LoggingHandler
import org.github.module.echo.shaded.AbsIntEncoder
import org.junit.Assert
import org.junit.Test

class AbsIntEncoderTest {
  @Test
  fun test() {
    val buf = Unpooled.buffer()!!
    buf
      .writeInt(-1)
      .writeInt(-2)
      .writeInt(-3)
      .writeInt(-4)
      .writeInt(-5)
      .writeInt(-6)
      .writeInt(-7)
      .writeInt(-8)
      .writeInt(-9)
    val channel = EmbeddedChannel(LoggingHandler(), AbsIntEncoder())
    Assert.assertTrue(channel.writeOutbound(buf))
    Assert.assertTrue(channel.finish())

    Assert.assertEquals(1, channel.readOutbound<Int>())
    Assert.assertEquals(2, channel.readOutbound<Int>())
    Assert.assertEquals(3, channel.readOutbound<Int>())
    Assert.assertEquals(4, channel.readOutbound<Int>())
    Assert.assertEquals(5, channel.readOutbound<Int>())
    Assert.assertEquals(6, channel.readOutbound<Int>())
    Assert.assertEquals(7, channel.readOutbound<Int>())
    Assert.assertEquals(8, channel.readOutbound<Int>())
    Assert.assertEquals(9, channel.readOutbound<Int>())
    Assert.assertNull(channel.readOutbound())
  }
}
