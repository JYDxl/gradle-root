package org.github.netty

import io.netty.bootstrap.Bootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.nio.NioSocketChannel
import io.netty.handler.codec.LengthFieldBasedFrameDecoder
import io.netty.handler.logging.LoggingHandler
import io.netty.util.concurrent.DefaultThreadFactory
import org.github.core.netty.ops.eventLoopGroup
import org.github.netty.module.echo.shaded.EchoClientHandler
import java.nio.ByteOrder.LITTLE_ENDIAN

fun main() {
  val group = eventLoopGroup(24, DefaultThreadFactory("nio-client"))

  Bootstrap()
    .group(group)
    .channel(NioSocketChannel::class.java)
    .handler(object: ChannelInitializer<Channel>() {
      override fun initChannel(channel: Channel) {
        channel.pipeline().apply {
          addLast(LoggingHandler())
          addLast(LengthFieldBasedFrameDecoder(LITTLE_ENDIAN, 65535, 0, 2, -2, 0, false))
          addLast(EchoClientHandler())
        }
      }
    })
    .connect("192.168.50.66", 10001)
    .sync()
    .channel()
    .closeFuture()
    .addListener {group.shutdownGracefully()}
}
