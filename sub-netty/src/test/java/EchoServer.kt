import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.kqueue.KQueueEventLoopGroup
import io.netty.channel.kqueue.KQueueServerSocketChannel
import io.netty.channel.kqueue.KQueueSocketChannel
import io.netty.handler.codec.FixedLengthFrameDecoder
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.logging.LoggingHandler
import org.github.echo.EchoEncoder
import org.github.echo.EchoServerHandler
import org.github.thread.NaiveThreadFactory

fun main() {
  val echoEncoder = EchoEncoder()
  val stringDecoder = StringDecoder()
  val echoHandler = EchoServerHandler()
  val loggingHandler = LoggingHandler()

  val boss = KQueueEventLoopGroup(1, NaiveThreadFactory("kqueue-boss"))
  val worker = KQueueEventLoopGroup(24, NaiveThreadFactory("kqueue-worker"))
  val serverBootstrap = ServerBootstrap()
    .group(boss, worker)
    .channel(KQueueServerSocketChannel::class.java)
    .handler(loggingHandler)
    .childHandler(object: ChannelInitializer<KQueueSocketChannel>() {
      override fun initChannel(channel: KQueueSocketChannel) {
        channel.pipeline()!!.apply {
          addLast(loggingHandler)
          addLast(FixedLengthFrameDecoder(4))
          addLast(stringDecoder)
          addLast(echoEncoder)
          addLast(echoHandler)
        }
      }
    })!!

  try {
    serverBootstrap.bind(8000).sync()
    serverBootstrap.bind(8001).sync().channel().closeFuture().sync()
  } catch(e: Exception) {
    e.printStackTrace()
  } finally {
    boss.shutdownGracefully()
    worker.shutdownGracefully()
  }
}
