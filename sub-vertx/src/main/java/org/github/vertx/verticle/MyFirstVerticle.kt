package org.github.vertx.verticle

import io.vertx.core.AbstractVerticle

class MyFirstVerticle : AbstractVerticle() {
  override fun start() {
    vertx
      .createHttpServer()
      .requestHandler { it.response().end("Hello world!") }
      .listen(10001)
  }
}
