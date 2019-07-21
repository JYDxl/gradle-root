package org.github

import io.netty.bootstrap.Bootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption
import io.netty.channel.kqueue.KQueueEventLoopGroup
import io.netty.channel.kqueue.KQueueSocketChannel
import io.netty.handler.codec.LengthFieldBasedFrameDecoder
import org.github.netty.Header
import org.github.netty.Message

fun main() {
  val worker = KQueueEventLoopGroup()

  Bootstrap()
    .group(worker)
    .channel(KQueueSocketChannel::class.java)
    .option(ChannelOption.TCP_NODELAY, true)
    .handler(object: ChannelInitializer<Channel>() {
      override fun initChannel(ch: Channel) {
        ch.pipeline()!!.apply {
          addLast(LengthFieldBasedFrameDecoder(1024, 4, 4))
        }
      }
    })
    .connect("127.0.0.1", 9002)
    .sync()
    .channel()
    .closeFuture()
    .addListener { worker.shutdownGracefully() }
}

class LoginAuthReqHandler: ChannelInboundHandlerAdapter() {
  override fun channelActive(ctx: ChannelHandlerContext) {
    Message().apply {
      header = Header().apply {

      }
    }
  }
}
