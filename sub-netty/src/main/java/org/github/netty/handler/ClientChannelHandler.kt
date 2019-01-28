package org.github.netty.handler

import com.google.protobuf.util.JsonFormat.printer
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.github.netty.protobuf.SubscribeReqProto.SubscribeReq
import org.github.netty.protobuf.SubscribeRespProto.SubscribeResp
import org.slf4j.LoggerFactory.getLogger

class ClientChannelHandler : ChannelInboundHandlerAdapter() {
  override fun channelActive(ctx: ChannelHandlerContext) {
    val req = SubscribeReq.newBuilder()!!.apply {
      subReqId = 1
      username = "JYD_XL"
      productName = "Netty Book"
      val list = arrayListOf("NanJing YuHuaTai", "BeiJing LiuLiChang", "ShenZhen HongShuLin")
      addAllAddress(list)
    }.build()!!

    for (i in 1..10) {
      ctx.writeAndFlush(req)
    }
  }

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    msg as SubscribeResp
    log.info(printer().print(msg))
  }
}

/** log. */
private val log = getLogger(ClientChannelHandler::class.java)!!
