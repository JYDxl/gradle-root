package org.github.vertx.verticle

import io.vertx.core.AbstractVerticle
import io.vertx.core.AsyncResult
import io.vertx.core.http.HttpServer
import io.vertx.core.http.HttpServerOptions
import io.vertx.ext.web.Router
import org.github.ops.error
import org.github.ops.info
import org.github.ops.log

class MyFirstVerticle: AbstractVerticle() {
  /** log. */
  private val log = MyFirstVerticle::class.log

  override fun start() {
    val httpServerOptions = HttpServerOptions().apply {
      logActivity = true
    }
    val httpServer = vertx.createHttpServer(httpServerOptions)!!
    val router = Router.router(vertx)!!
    router.route().handler { it.response().end("OK") }
    httpServer.requestHandler(router).listen(10000) { result: AsyncResult<HttpServer> ->
      if(result.succeeded()) {
        log.info { "${result.result()}启动成功" }
      } else {
        log.error(result.cause()) { result.cause().message }
      }
    }
  }
}
