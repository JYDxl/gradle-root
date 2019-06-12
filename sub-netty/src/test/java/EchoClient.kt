import io.netty.bootstrap.Bootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioSocketChannel
import io.netty.handler.codec.LineBasedFrameDecoder
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.logging.LoggingHandler
import org.github.echo.EchoClientHandler
import org.github.echo.EchoEncoder
import org.github.thread.NaiveThreadFactory

fun main() {
  val group = NioEventLoopGroup(24, NaiveThreadFactory("nio-client"))
  val bootstrap = Bootstrap()
    .group(group)
    .channel(NioSocketChannel::class.java)
    .handler(object: ChannelInitializer<NioSocketChannel>() {
      override fun initChannel(channel: NioSocketChannel) {
        channel.pipeline()!!.apply {
          addLast(LoggingHandler())
          addLast(LineBasedFrameDecoder(1024))
          addLast(StringDecoder())
          addLast(EchoEncoder())
          addLast(EchoClientHandler())
        }
      }
    })!!

  try {
    bootstrap
      .connect("127.0.0.1", 8000)
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
