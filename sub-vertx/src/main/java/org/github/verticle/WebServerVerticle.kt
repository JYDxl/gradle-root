package org.github.verticle

import io.netty.handler.codec.http.HttpHeaderValues.*
import io.vertx.core.AbstractVerticle
import io.vertx.core.http.HttpServerOptions
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.handler.BodyHandler
import io.vertx.ext.web.handler.LoggerHandler
import io.vertx.ext.web.handler.SessionHandler
import io.vertx.ext.web.sstore.LocalSessionStore
import org.github.ops.info
import org.github.ops.log

class WebServerVerticle: AbstractVerticle() {
  override fun start() {
    val router = Router.router(vertx)!!
    router.route().handler(LoggerHandler.create())
    router.route().handler(BodyHandler.create().setDeleteUploadedFilesOnEnd(true))
    router.route().handler(SessionHandler.create(LocalSessionStore.create(vertx)))
    router.route().produces(TEXT_PLAIN.toString()).handler { ctx: RoutingContext ->
      val req = ctx.request()!!
      val res = ctx.response()!!
      ctx.user()
      log.info { "${req.path()} ${req.method()}" }
      res.end("Hello world!")
    }
    vertx.createHttpServer(HttpServerOptions().apply { logActivity = true }).requestHandler(router).listen(3000)
  }
}

private val log = WebServerVerticle::class.log
