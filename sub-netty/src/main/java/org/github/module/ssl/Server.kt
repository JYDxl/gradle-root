package org.github.module.ssl

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.*
import io.netty.channel.ChannelHandler.*
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.codec.string.StringEncoder
import io.netty.handler.logging.LogLevel.*
import io.netty.handler.logging.LoggingHandler
import io.netty.handler.ssl.SslContextBuilder.*
import org.github.netty.decoder.DefaultLineDecoder
import org.github.netty.handler.ReadWriteInfoHandler
import org.github.netty.ops.eventLoopGroup
import org.github.netty.ops.hasMark
import org.github.netty.ops.mark
import org.github.netty.ops.serverSocketChannel
import org.github.ops.info
import org.github.ops.log
import org.github.thread.NativeThreadFactory
import java.io.File
import java.util.*
import java.util.function.Function
import kotlin.text.Charsets.UTF_8

fun main() {
  val ca = File("ssl/ca.crt")
  val serverCrt = File("ssl/server/server.crt")
  val serverKey = File("ssl/server/pkcs8_server.key")
  val sslCtx = forServer(serverCrt, serverKey).trustManager(ca).build()

  val loggingHandler = LoggingHandler(TRACE)
  val readWriteInfoHandler = ReadWriteInfoHandler(Function { it.toString().trim() })
  val stringDecoder = StringDecoder(UTF_8)
  val stringEncoder = StringEncoder(UTF_8)
  val serverHandler = ServerHandler()

  val boss = eventLoopGroup(1, NativeThreadFactory("ssl-server-boss"))
  val worker = eventLoopGroup(0, NativeThreadFactory("ssl-server-worker"))
  val listener = ChannelFutureListener { boss.shutdownGracefully();worker.shutdownGracefully() }

  ServerBootstrap()
    .group(boss, worker)
    .channel(serverSocketChannel)
    .handler(loggingHandler)
    .childHandler(object: ChannelInitializer<Channel>() {
      override fun initChannel(ch: Channel) {
        ch.pipeline().apply {
          addLast(sslCtx.newHandler(ch.alloc()))
          addLast(loggingHandler)
          addLast(DefaultLineDecoder(1024, false))
          addLast(stringDecoder)
          addLast(stringEncoder)
          addLast(readWriteInfoHandler)
          addLast(LinkHandler())
          addLast(serverHandler)
        }
      }
    })
    .bind(10000)
    .sync()
    .channel()
    .closeFuture()
    .addListener(listener)
}

@Sharable
class ServerHandler: ChannelInboundHandlerAdapter() {
  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    msg as String
    val channel = ctx.channel()
    if(!channel.hasMark) channel.mark.set(msg.trim())
    ctx.write(msg, ctx.voidPromise())
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    ctx.flush()
  }
}

class LinkHandler: ChannelInboundHandlerAdapter() {
  private val link = LinkedList<String>()

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    msg as String
    link.add(msg)
    log.info { "当前暂存有${link.size}条数据: $link" }
    if(link.size < 10) return
    val array = link.toTypedArray()
    link.clear()
    for(item in array) {
      super.channelRead(ctx, msg)
    }
  }
}

private val log = LinkHandler::class.log
