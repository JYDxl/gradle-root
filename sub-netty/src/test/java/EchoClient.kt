import io.netty.bootstrap.Bootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioSocketChannel
import io.netty.handler.codec.LengthFieldBasedFrameDecoder
import io.netty.handler.logging.LoggingHandler
import org.github.echo.EchoClientHandler
import org.github.thread.NaiveThreadFactory
import java.nio.ByteOrder

fun main() {
  val group = NioEventLoopGroup(24, NaiveThreadFactory("nio-client"))
  val bootstrap = Bootstrap()
    .group(group)
    .channel(NioSocketChannel::class.java)
    .handler(object: ChannelInitializer<NioSocketChannel>() {
      override fun initChannel(channel: NioSocketChannel) {
        channel.pipeline()!!.apply {
          addLast(LoggingHandler())
          addLast(LengthFieldBasedFrameDecoder(ByteOrder.LITTLE_ENDIAN, 65535, 0, 2, -2, 0, false))
          //          addLast(EchoEncoder())
          addLast(EchoClientHandler())
        }
      }
    })!!

  try {
    bootstrap
      .connect("192.168.50.66", 10001)
      .sync()
      .channel()
      .closeFuture()
      .sync()
  } catch(e: Exception) {
    e.printStackTrace()
  } finally {
    group.shutdownGracefully()
  }
}
