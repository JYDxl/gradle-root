package org.github.vertx.verticle

import io.vertx.core.http.HttpServer
import io.vertx.core.http.HttpServerOptions
import io.vertx.ext.web.Route
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.handler.BodyHandler
import io.vertx.ext.web.handler.LoggerFormat.SHORT
import io.vertx.ext.web.handler.LoggerHandler
import io.vertx.kotlin.coroutines.CoroutineVerticle
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import org.github.core.ops.error
import org.github.core.ops.info
import org.github.core.ops.log
import org.github.core.ops.trace
import org.github.vertx.ops.CoroutineVertxRouteHandler
import org.github.vertx.ops.name

class HttpServerVerticle(private val port: Int = 3000): CoroutineVerticle() {
  /** HTTP服务器. */
  private lateinit var httpServer: HttpServer

  override suspend fun start() {
    initHttpServer()
    consumeHttpSayHello()
  }

  private fun consumeHttpSayHello() {
    // val channel = vertx.consumer<Buffer, String>(HTTP_SAY_HELLO)
    // launch {
    //   for(msg in channel) {
    //     val req = msg.body().toString(UTF_8)
    //     log.warn { req }
    //     val res = req.toUpperCase().toBuffer()
    //     msg.reply(res)
    //   }
    // }
    //
    // val timeChannel: ReceiveChannel<Long> = vertx.periodicStream(ofSeconds(10).toMillis()).toChannel(vertx)
    // launch {
    //   for(ignore in timeChannel) {
    //     val (_, res) = vertx.requestAwait<Buffer, String>(HTTP_SAY_HELLO, "bilibili".toBuffer())
    //     log.warn { res }
    //   }
    // }
  }

  private suspend fun initHttpServer() {
    val httpServerOptions = HttpServerOptions().apply {
      logActivity = true
      //      isSsl = true
      //      keyStoreOptions = JksOptions().apply {
      //        path = "cert/vertx.keystore"
      //        password = "example"
      //      }
    }
    val router = Router.router(vertx)
    val bodyHandler = BodyHandler.create().setDeleteUploadedFilesOnEnd(true)
    val logHandler = LoggerHandler.create(SHORT)
    router.route().handler(logHandler).handler(bodyHandler)

    // router.post("/score").coroutineHandler(Handler::handler2Score)
    // router.route("/sleep").coroutineHandler(Handler::handler2Sleep)

    httpServer = vertx.createHttpServer(httpServerOptions).requestHandler(router).listen(port).await()
    log.info {"HTTP服务启动成功,监听在[$port]端口"}
  }

  private fun Route.coroutineHandler(fn: CoroutineVertxRouteHandler) {
    val name = fn.name
    handler {ctx: RoutingContext ->
      launch(ctx.vertx().dispatcher() + CoroutineName(name)) {
        log.trace {"Touch $fn"}
        try {
          fn(ctx)
        } catch (e: Exception) {
          log.error(e) {}
          ctx.fail(e)
        }
      }
    }
  }
}

private val log = HttpServerVerticle::class.log
