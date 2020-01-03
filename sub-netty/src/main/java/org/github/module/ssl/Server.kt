package org.github.module.ssl

import io.netty.bootstrap.ServerBootstrap
import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufAllocator
import io.netty.buffer.Unpooled.*
import io.netty.channel.Channel
import io.netty.channel.ChannelFutureListener
import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.ChannelInitializer
import io.netty.channel.group.ChannelMatchers.*
import io.netty.channel.group.DefaultChannelGroup
import io.netty.handler.codec.MessageToMessageEncoder
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.logging.LogLevel.*
import io.netty.handler.logging.LoggingHandler
import io.netty.util.concurrent.ImmediateEventExecutor.*
import org.github.netty.decoder.DefaultLineDecoder
import org.github.netty.handler.ReadWriteHexHandler
import org.github.netty.handler.ReadWriteInfoHandler
import org.github.netty.ops.eventLoopGroup
import org.github.netty.ops.serverSocketChannel
import org.github.netty.ops.toByteBuf
import org.github.thread.NativeThreadFactory
import java.util.function.Function
import kotlin.text.Charsets.UTF_8

fun main() {
  // val ca = "ssl/ca.crt".classpathFile
  // val serverCrt = "ssl/server/server.crt".classpathFile
  // val serverKey = "ssl/server/pkcs8_server.key".classpathFile
  // val sslCtx = forServer(serverCrt, serverKey).trustManager(ca).sslProvider(OPENSSL).build()

  val loggingHandler = LoggingHandler(TRACE)
  val readWriteInfoHandler = ReadWriteInfoHandler(Function { it.toString().trim() })
  val stringDecoder = StringDecoder(UTF_8)
  val stringEncoder = StringEncoder()
  val serverHandler = ServerHandler()
  val readWriteHexHandler = ReadWriteHexHandler()

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
          // addLast(sslCtx.newHandler(ch.alloc()))
          addLast(loggingHandler)
          addLast(DefaultLineDecoder(1024, false))
          addLast(readWriteHexHandler)
          addLast(stringDecoder)
          addLast(stringEncoder)
          addLast(readWriteInfoHandler)
          // addLast(LinkHandler())
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
  private val group = DefaultChannelGroup(INSTANCE)

  override fun channelActive(ctx: ChannelHandlerContext) {
    group.add(ctx.channel())
  }

  override fun channelRead(ctx: ChannelHandlerContext, input: Any) {
    val msg = (input as String).trim()
    group.writeAndFlush(msg, isNot(ctx.channel()), true)
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    ctx.flush()
  }
}

@Sharable
class StringEncoder: MessageToMessageEncoder<String>() {
  override fun encode(ctx: ChannelHandlerContext, msg: String, out: MutableList<Any>) {
    msg.encodeToByteBuf(ctx.alloc())?.let { out.add(it) }
  }
}

const val end = '\n'

val tail: ByteBuf = unreleasableBuffer(directBuffer(1).writeByte(end.toInt()))

fun String.encodeToByteBuf(alloc: ByteBufAllocator): ByteBuf? {
  if(isBlank()) return null
  val body = toByteBuf(alloc)
  if(endsWith(end)) return body
  return alloc.compositeDirectBuffer(2).apply {
    addComponents(true, body, tail)
  }
}

// class LinkHandler: ChannelInboundHandlerAdapter() {
//   private val link = LinkedList<String>()
//
//   override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
//     msg as String
//     link.add(msg)
//     log.info { "当前暂存有${link.size}条数据: $link" }
//     if(link.size < 10) return
//     val array = link.toTypedArray()
//     link.clear()
//     for(item in array) {
//       super.channelRead(ctx, item)
//     }
//   }
// }
//
// private val log = LinkHandler::class.log
