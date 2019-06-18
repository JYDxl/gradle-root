package org.github.vertx.verticle

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.http.HttpServerOptions
import io.vertx.core.http.ServerWebSocket
import io.vertx.ext.web.Router
import org.github.ops.log

class MyFirstVerticle: AbstractVerticle() {
  /** log. */
  private val log = MyFirstVerticle::class.log

  override fun start() {
    val httpServerOptions = HttpServerOptions().apply {
      logActivity = true
      this.websocketAllowServerNoContext
    }
    val httpServer = vertx.createHttpServer(httpServerOptions)!!
    val router = Router.router(vertx)!!
    httpServer.websocketHandler { websocket: ServerWebSocket ->
      websocket.setHandshake(Future.future())
    }
    httpServer.requestHandler(router).listen(10000)
  }
}
