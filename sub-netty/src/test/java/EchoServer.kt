import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.group.DefaultChannelGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.channel.socket.nio.NioSocketChannel
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import io.netty.util.concurrent.ImmediateEventExecutor
import org.github.echo.EchoEncoder
import org.github.echo.EchoServerHandler
import org.github.echo.LineDecoderWithPreChecker
import org.github.thread.NaiveThreadFactory

fun main() {
  val echoEncoder = EchoEncoder()
  val stringDecoder = StringDecoder()
  val channelGroup = DefaultChannelGroup("group-echo", ImmediateEventExecutor.INSTANCE)
  val echoHandler = EchoServerHandler(channelGroup)
  val loggingHandler = LoggingHandler(TRACE)

  val boss = NioEventLoopGroup(1, NaiveThreadFactory("nio-boss"))
  val worker = NioEventLoopGroup(24, NaiveThreadFactory("nio-worker"))
  val serverBootstrap = ServerBootstrap()
    .group(boss, worker)
    .channel(NioServerSocketChannel::class.java)
    .handler(loggingHandler)
    .childHandler(object: ChannelInitializer<NioSocketChannel>() {
      override fun initChannel(channel: NioSocketChannel) {
        channel.pipeline()!!.apply {
          addLast(loggingHandler)
          addLast(LineDecoderWithPreChecker(1024))
          addLast(stringDecoder)
          addLast(echoEncoder)
          addLast(echoHandler)
        }
      }
    })!!

  try {
    serverBootstrap.bind(8000).sync().channel().closeFuture().sync()
  } catch(e: Exception) {
    e.printStackTrace()
  } finally {
    boss.shutdownGracefully()
    worker.shutdownGracefully()
  }
}
