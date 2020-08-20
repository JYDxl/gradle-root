package org.github.module.file

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption.*
import io.netty.channel.DefaultFileRegion
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.codec.string.StringEncoder
import io.netty.handler.logging.LogLevel.*
import io.netty.handler.logging.LoggingHandler
import io.netty.handler.ssl.SslContextBuilder.*
import io.netty.handler.ssl.SslHandler
import io.netty.handler.ssl.SslProvider.*
import io.netty.handler.stream.ChunkedFile
import io.netty.handler.stream.ChunkedWriteHandler
import org.github.netty.decoder.DefaultLineDecoder
import org.github.netty.ops.eventLoopGroup
import org.github.netty.ops.serverSocketChannel
import org.github.ops.classpathFile
import java.io.RandomAccessFile
import kotlin.text.Charsets.UTF_8

fun main() {
  val ca = "ssl/ca.crt".classpathFile
  val serverCrt = "ssl/server/server.crt".classpathFile
  val serverKey = "ssl/server/pkcs8_server.key".classpathFile
  val sslCtx = forServer(serverCrt, serverKey).trustManager(ca).sslProvider(OPENSSL).build()

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
          addLast(DefaultLineDecoder(1024))
          addLast(stringDecoder)
          addLast(stringEncoder)
          addLast(ChunkedWriteHandler())
          addLast(serverHandler)
        }
      }
    })
    .bind(10000).sync().channel().closeFuture()
    .addListener { worker.shutdownGracefully(); boss.shutdownGracefully() }
}

@Sharable
class ServerHandler: ChannelInboundHandlerAdapter() {
  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    msg as String
    val file = RandomAccessFile(msg, "r")
    val size = file.length()
    ctx.write("AA")
    ctx.write(ctx.alloc().buffer(8).writeLong(size))
    if(ctx.pipeline().get(SslHandler::class.java) == null) {
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
