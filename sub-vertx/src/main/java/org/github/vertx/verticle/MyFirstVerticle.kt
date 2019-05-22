package org.github.vertx.verticle

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpServerRequest
import org.github.ops.error
import org.github.ops.log

class MyFirstVerticle : AbstractVerticle() {
  /** log. */
  private val log = MyFirstVerticle::class.log

  override fun start() {
    vertx
      .createHttpServer()
      .requestHandler { req: HttpServerRequest ->
        val fs = vertx.fileSystem()!!
        Future.future<Void>().apply {
          fs.createFile("foo", this)
        }.compose {
          return@compose Future.future<Void>().apply {
            fs.writeFile("foo", Buffer.buffer("foo"), this)
          }
        }.compose {
          return@compose Future.future<Void>().apply {
            fs.move("foo", "bar", this)
          }
        }.setHandler {
          val resp = req.response()!!
          if(it.succeeded()) {
            resp.end("OK!")
          } else {
            val throwable = it.cause()!!
            log.error(throwable) { throwable.message }
            resp.end("ERROR!")
          }
        }
      }
      .listen(10000)
  }
}
