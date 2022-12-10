package org.github.core.netty.decoder

import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled.buffer
import io.netty.channel.embedded.EmbeddedChannel
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import kotlin.Int.Companion.MAX_VALUE
import kotlin.reflect.jvm.jvmName
import kotlin.text.Charsets.UTF_8
import org.github.core.netty.decoder.LengthDecoder
import org.github.core.netty.ops.markAttr
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class LengthDecoderTest {
  @Test
  fun decode() {
    val decoder = LengthDecoder(0, 4, MAX_VALUE, 0, 4)
    val channel = EmbeddedChannel(LoggingHandler(TRACE), decoder, StringDecoder(UTF_8))
    // val part1 = DefaultLengthDecoder::class.jvmName.toByteBuf()
    // val part2 = EmbeddedChannel::class.jvmName.toByteBuf()
    // val head1 = wrappedBuffer(toByteArray(part1.readableBytes()))
    // val head2 = wrappedBuffer(toByteArray(part2.readableBytes()))
    // val buf = compositeBuffer(4).apply { addComponents(true, head1, part1, head2, part2) }
    val part1 = LengthDecoder::class.jvmName.toByteArray()
    val part2 = EmbeddedChannel::class.jvmName.toByteArray()
    val buf: ByteBuf = buffer(4 + part1.size + 4 + part2.size).apply {
      writeInt(part1.size)
      writeBytes(part1)
      writeInt(part2.size)
      writeBytes(part2)
    }
    assertTrue(channel.writeInbound(buf))
    assertTrue(channel.finish())
    val msg1: String = channel.readInbound()
    assertEquals(msg1, LengthDecoder::class.jvmName)
    val msg2: String = channel.readInbound()
    assertEquals(msg2, EmbeddedChannel::class.jvmName)
    val msg3: String? = channel.readInbound<String>()
    assertNull(msg3)
    println(channel.markAttr)
  }
}
