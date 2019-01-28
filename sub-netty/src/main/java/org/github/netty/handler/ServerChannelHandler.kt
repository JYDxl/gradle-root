package org.github.netty.handler

import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.github.netty.protobuf.SubscribeReqProto.SubscribeReq
import org.github.netty.protobuf.SubscribeRespProto.SubscribeResp
import org.slf4j.LoggerFactory.getLogger

@Sharable
class ServerChannelHandler : ChannelInboundHandlerAdapter() {
  override fun channelActive(ctx: ChannelHandlerContext) {
    log.info("ACTIVE")
  }

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    msg as SubscribeReq
    log.info(msg.toString())
    val resp = SubscribeResp.newBuilder()!!.apply {
      subReqId = msg.subReqId
      respCode = 0
      desc = "Netty book order succeed, 3 days later, sent to the designated address!"
    }.build()!!
    ctx.writeAndFlush(resp)
  }

  override fun channelInactive(ctx: ChannelHandlerContext) {
    log.info("IN_ACTIVE")
  }
}

/** log. */
private val log = getLogger(ServerChannelHandler::class.java)!!
