package org.github.module.file

import cn.hutool.core.io.FileUtil.file
import com.google.common.io.Files
import io.netty.bootstrap.Bootstrap
import io.netty.buffer.ByteBuf
import io.netty.channel.Channel
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.ChannelInitializer
import io.netty.handler.codec.MessageToMessageDecoder
import io.netty.handler.codec.string.StringEncoder
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import io.netty.handler.ssl.SslContext
import io.netty.handler.ssl.SslContextBuilder.forClient
import org.github.netty.decoder.LengthDecoder
import org.github.netty.ops.beforeRelease
import org.github.netty.ops.eventLoopGroup
import org.github.netty.ops.socketChannel
import org.github.ops.info
import org.github.ops.log
import java.io.File
import kotlin.Int.Companion.MAX_VALUE
import kotlin.text.Charsets.UTF_8

fun main() {
  val ca: File = file("ssl/ca.crt")
  val clientCrt: File = file("ssl/client/client.crt")
  val clientKey: File = file("ssl/client/pkcs8_client.key")
  val sslCtx: SslContext = forClient().keyManager(clientCrt, clientKey).trustManager(ca).build()
  val stringEncoder = StringEncoder(UTF_8)
  val clientDecoder = ClientDecoder()
  val loggingHandler = LoggingHandler(TRACE)
  val clientHandler = ClientHandler()
  val group = eventLoopGroup(1, "file-client")

  Bootstrap()
    .group(group)
    .channel(socketChannel)
    .handler(object: ChannelInitializer<Channel>() {
      override fun initChannel(ch: Channel) {
        ch.pipeline().apply {
          addLast(sslCtx.newHandler(ch.alloc()))
          addLast(loggingHandler)
          addLast(LengthDecoder(MAX_VALUE, 2, 8, 2))
          addLast(clientDecoder)
          addLast(stringEncoder)
          addLast(clientHandler)
        }
      }
    })
    .connect("localhost", 10000)
    .sync()
    .channel()
    .closeFuture()
    .addListener {group.shutdownGracefully()}
}

data class Data(var prefix: String = "", var suffix: String = "", var data: ByteArray = byteArrayOf()) {
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as Data

    if (prefix != other.prefix) return false
    if (suffix != other.suffix) return false
    if (!data.contentEquals(other.data)) return false

    return true
  }

  override fun hashCode(): Int {
    var result = prefix.hashCode()
    result = 31 * result + suffix.hashCode()
    result = 31 * result + data.contentHashCode()
    return result
  }

  override fun toString(): String {
    return "Data(prefix='$prefix',size='${data.size}', suffix='$suffix')"
  }
}

@Sharable
class ClientDecoder: MessageToMessageDecoder<ByteBuf>() {
  override fun decode(ctx: ChannelHandlerContext, msg: ByteBuf, out: MutableList<Any>) {
    val data = Data()
    msg.readRetainedSlice(2).beforeRelease {data.prefix = toString(UTF_8)}
    val len = msg.readLong()
    val ary = ByteArray(len.toInt()).apply {msg.readBytes(this)}
    data.data = ary
    msg.readRetainedSlice(2).beforeRelease {data.suffix = toString(UTF_8)}
    out.add(data)
  }
}

@Sharable
class ClientHandler: ChannelInboundHandlerAdapter() {
  override fun channelActive(ctx: ChannelHandlerContext) {
    ctx.writeAndFlush("D:\\GitHub\\gradle-root\\kotlin.jpg\n")
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    ctx.flush()
  }

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    msg as Data
    log.info {msg}
    Files.write(msg.data, File("D:\\GitHub\\gradle-root\\kotlin-bak.jpg"))
    log.info {"文件下载成功"}
  }

  private val log = ClientHandler::class.log
}
