package org.github.module.file

import cn.hutool.core.io.FileUtil.file
import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.*
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelOption.SO_REUSEADDR
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.codec.string.StringEncoder
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import io.netty.handler.ssl.SslContext
import io.netty.handler.ssl.SslContextBuilder.forServer
import io.netty.handler.ssl.SslHandler
import io.netty.handler.ssl.SslProvider.OPENSSL
import io.netty.handler.stream.ChunkedFile
import io.netty.handler.stream.ChunkedWriteHandler
import org.github.netty.decoder.LineDecoder
import org.github.netty.ops.eventLoopGroup
import org.github.netty.ops.serverSocketChannel
import java.io.File
import java.io.RandomAccessFile
import kotlin.text.Charsets.UTF_8

fun main() {
  val ca: File = file("ssl/ca.crt")
  val serverCrt: File = file("ssl/server/server.crt")
  val serverKey: File = file("ssl/server/pkcs8_server.key")
  val sslCtx: SslContext = forServer(serverCrt, serverKey).trustManager(ca).sslProvider(OPENSSL).build()

  val loggingHandler = LoggingHandler(TRACE)
  val stringDecoder = StringDecoder(UTF_8)
  val stringEncoder = StringEncoder(UTF_8)
  val serverHandler = ServerHandler()

  val boss = eventLoopGroup(1, "file-server-boss")
  val worker = eventLoopGroup(0, "file-server-worker")

  ServerBootstrap()
    .group(boss, worker)
    .channel(serverSocketChannel)
    .handler(loggingHandler)
    .option(SO_REUSEADDR, true)
    .childHandler(object: ChannelInitializer<Channel>() {
      override fun initChannel(ch: Channel) {
        ch.pipeline().apply {
          addLast(sslCtx.newHandler(ch.alloc()))
          addLast(loggingHandler)
          addLast(LineDecoder(1024))
          addLast(stringDecoder)
          addLast(stringEncoder)
          addLast(ChunkedWriteHandler())
          addLast(serverHandler)
        }
      }
    })
    .bind(10000).sync().channel().closeFuture()
    .addListener {worker.shutdownGracefully(); boss.shutdownGracefully()}
}

@Sharable
class ServerHandler: ChannelInboundHandlerAdapter() {
  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    msg as String
    val file = RandomAccessFile(msg, "r")
    val size = file.length()
    ctx.write("AA")
    ctx.write(ctx.alloc().buffer(8).writeLong(size))
    if (ctx.pipeline().get(SslHandler::class.java) == null) {
      ctx.write(DefaultFileRegion(file.channel, 0, size))
    } else {
      ctx.write(ChunkedFile(file))
    }
    ctx.write("BB")
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    ctx.flush()
  }
}
