package org.github.module.ssl

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption.SO_REUSEADDR
import io.netty.channel.group.ChannelMatcher
import io.netty.channel.group.ChannelMatchers.isNot
import io.netty.channel.group.DefaultChannelGroup
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import io.netty.util.concurrent.DefaultThreadFactory
import io.netty.util.concurrent.GlobalEventExecutor.INSTANCE
import org.github.module.ssl.codec.ServerDecoder
import org.github.module.ssl.codec.ServerEncoder
import org.github.module.ssl.codec.toByteBuf
import org.github.netty.decoder.LineDecoder
import org.github.netty.ops.eventLoopGroup
import org.github.netty.ops.serverSocketChannel

fun main() {
  // val ca = "ssl/ca.crt".classpathFile
  // val serverCrt = "ssl/server/server.crt".classpathFile
  // val serverKey = "ssl/server/pkcs8_server.key".classpathFile
  // val sslCtx = forServer(serverCrt, serverKey).trustManager(ca).sslProvider(OPENSSL).build()

  val loggingHandler = LoggingHandler(TRACE)
  // val readWriteInfoHandler = ReadWriteInfoHandler(Function { it.toString().trim() })
  val decoder = ServerDecoder()
  val encoder = ServerEncoder()

  val boss = eventLoopGroup(2, DefaultThreadFactory("ssl-server-boss"))
  val worker = eventLoopGroup(0, DefaultThreadFactory("ssl-server-worker"))
  val group = DefaultChannelGroup(INSTANCE)
  val serverHandler = ServerHandler(group)

  val bootstrap = ServerBootstrap()
    .group(boss, worker)
    .channel(serverSocketChannel)
    .handler(loggingHandler)
    .option(SO_REUSEADDR, true)
    .childHandler(object: ChannelInitializer<Channel>() {
      override fun initChannel(ch: Channel) {
        ch.pipeline().apply {
          // addLast(sslCtx.newHandler(ch.alloc()))
          addLast(loggingHandler)
          addLast(LineDecoder(1024))
          addLast(decoder)
          addLast(encoder)
          // addLast(readWriteInfoHandler)
          // addLast(LinkHandler())
          addLast(serverHandler)
        }
      }
    })
  group.add(bootstrap.bind(10000).sync().channel())
  group.add(bootstrap.bind(20000).sync().channel())
}

@Sharable
class ServerHandler(private val group: DefaultChannelGroup): ChannelInboundHandlerAdapter() {
  override fun channelActive(ctx: ChannelHandlerContext) {
    group.add(ctx.channel())
  }

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    msg as String
    group.writeAndFlush(isNot(ctx.channel()), msg)
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    ctx.flush()
  }
}

fun DefaultChannelGroup.writeAndFlush(matcher: ChannelMatcher, message: CharSequence) {
  writeAndFlush(message.toByteBuf(), matcher, true)
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
