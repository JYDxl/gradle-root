package org.github.netty

import io.netty.bootstrap.Bootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.ChannelInitializer
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.codec.string.StringEncoder
import io.netty.handler.logging.LogLevel.*
import io.netty.handler.logging.LoggingHandler
import io.netty.util.AttributeKey
import io.netty.util.concurrent.DefaultThreadFactory
import io.netty.util.concurrent.EventExecutor
import io.netty.util.concurrent.Future
import org.github.core.netty.decoder.LineDecoder
import org.github.core.netty.ops.eventLoopGroup
import org.github.core.netty.ops.socketChannel
import org.github.core.ops.info
import org.github.core.ops.log
import org.github.core.ops.warn
import java.net.InetSocketAddress.*
import java.util.concurrent.TimeUnit.*
import kotlin.text.Charsets.UTF_8

fun main() {
  val group = eventLoopGroup(1, DefaultThreadFactory("tcp-client"))
  val bootstrap = Bootstrap()
  val address = createUnresolved("localhost", 10000)

  val loggingHandler = LoggingHandler(TRACE)
  val stringDecoder = StringDecoder(UTF_8)
  val stringEncoder = StringEncoder(UTF_8)
  val clientHandler = ClientHandler(bootstrap)

  bootstrap
    .group(group)
    .channel(socketChannel)
    .handler(object: ChannelInitializer<Channel>() {
      override fun initChannel(ch: Channel) {
        ch.pipeline().apply {
          addLast(loggingHandler)
          addLast(LineDecoder(1024, false))
          addLast(stringDecoder)
          addLast(stringEncoder)
          addLast(clientHandler)
        }
      }
    })
    .remoteAddress(address)
    .attr(addressKey, "TCP客户端($address)")
  bootstrap.connect().sync()
}

@Sharable
class ClientHandler(private val bootstrap: Bootstrap, private var retryCount: Int = 10): ChannelInboundHandlerAdapter() {

  private val maxRetry: Int = retryCount

  override fun channelInactive(ctx: ChannelHandlerContext) {
    log.warn { "${ctx.channel().attr(addressKey)}断开连接" }
    reconnect(ctx.executor())
  }

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    msg as String
    log.info { "received: $msg" }
    ctx.write(msg).addListener { it: Future<in Void> ->
      it as ChannelFuture
      if(it.isSuccess) {
        log.info { "${ctx.channel().attr(addressKey)}回复成功" }
      } else {
        log.warn(it.cause()) { "${ctx.channel().attr(addressKey)}回复失败" }
      }
    }
  }

  private fun reconnect(executor: EventExecutor) {
    if(retryCount > 0) {
      executor.schedule({ tryReconnect(executor) }, 5L * (maxRetry - retryCount).toLong(), SECONDS)
      retryCount--
    } else {
      executor.schedule({ tryReconnect(executor) }, 5L * maxRetry.toLong(), SECONDS)
    }
  }

  private fun tryReconnect(executor: EventExecutor) {
    bootstrap.connect().addListener { it: Future<in Void> ->
      it as ChannelFuture
      if(it.isSuccess) {
        log.info { "${it.channel().attr(addressKey)}重连成功" }
        retryCount = maxRetry
      } else {
        log.warn(it.cause()) { "${it.channel().attr(addressKey)}重连失败" }
        reconnect(executor)
      }
    }
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    ctx.flush()
  }
}

private val log = ClientHandler::class.log

private val addressKey: AttributeKey<String> = AttributeKey.newInstance("address")
