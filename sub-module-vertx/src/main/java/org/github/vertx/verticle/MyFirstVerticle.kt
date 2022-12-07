package org.github.vertx.verticle

import io.vertx.core.AbstractVerticle
import io.vertx.core.AsyncResult
import io.vertx.core.http.HttpServer
import io.vertx.core.http.HttpServerRequest
import org.github.core.ops.debug
import org.github.core.ops.error
import org.github.core.ops.log

class MyFirstVerticle(private val port: Int): AbstractVerticle() {
  /** log. */
  private val log = MyFirstVerticle::class.log

  override fun start() {
    vertx
      .createHttpServer()
      .requestHandler { handler: HttpServerRequest ->
        vertx.setTimer(5000) { handler.response().end("Hello world!") }
      }
      .listen(port) { ar: AsyncResult<HttpServer> ->
        if(ar.succeeded()) {
          log.debug { "HTTP Server $port OK" }
        } else {
          log.error { "HTTP Server $port ERROR" }
        }
      }
  }
}
