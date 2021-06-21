package org.github.module.ssl

import cn.hutool.core.io.FileUtil.file
import io.netty.bootstrap.Bootstrap
import io.netty.channel.*
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.codec.string.StringEncoder
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import io.netty.handler.ssl.SslContext
import io.netty.handler.ssl.SslContextBuilder.forClient
import org.github.netty.decoder.LineDecoder
import org.github.netty.handler.ReadWriteHexHandler
import org.github.netty.handler.ReadWriteInfoHandler
import org.github.netty.ops.eventLoopGroup
import org.github.netty.ops.socketChannel
import java.io.File
import java.util.concurrent.TimeUnit.SECONDS
import kotlin.text.Charsets.UTF_8

fun main() {
  val ca: File = file("ssl/ca.crt")
  val clientCrt: File = file("ssl/client/client.crt")
  val clientKey: File = file("ssl/client/pkcs8_client.key")
  val sslCtx: SslContext = forClient().keyManager(clientCrt, clientKey).trustManager(ca).build()

  val loggingHandler = LoggingHandler(TRACE)
  val readWriteInfoHandler = ReadWriteInfoHandler {it.toString().trim()}
  val stringDecoder = StringDecoder(UTF_8)
  val stringEncoder = StringEncoder(UTF_8)
  val clientHandler = ClientHandler()
  val readWriteHexHandler = ReadWriteHexHandler()

  val group = eventLoopGroup(1, "ssl-client")
  val listener = ChannelFutureListener {group.shutdownGracefully()}

  Bootstrap()
    .group(group)
    .channel(socketChannel)
    .handler(object: ChannelInitializer<Channel>() {
      override fun initChannel(ch: Channel) {
        ch.pipeline().apply {
          addLast(sslCtx.newHandler(ch.alloc()))
          addLast(loggingHandler)
          addLast(LineDecoder(1024, false))
          addLast(readWriteHexHandler)
          addLast(stringDecoder)
          addLast(stringEncoder)
          addLast(readWriteInfoHandler)
          addLast(clientHandler)
        }
      }
    })
    .connect("localhost", 10000)
    .sync()
    .channel()
    .closeFuture()
    .addListener(listener)
}

class ClientHandler: ChannelInboundHandlerAdapter() {
  override fun channelActive(ctx: ChannelHandlerContext) {
    ctx.executor().scheduleWithFixedDelay({ctx.writeAndFlush("2333\n2333\n2333", ctx.voidPromise())}, 0, 10, SECONDS)
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    ctx.flush()
  }

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {}
}
