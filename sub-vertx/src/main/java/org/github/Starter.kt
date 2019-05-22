package org.github

import io.vertx.core.Vertx
import io.vertx.core.VertxOptions
import org.github.vertx.verticle.MyFirstVerticle
import java.util.concurrent.TimeUnit

fun main() {
  val options = VertxOptions().apply {
    maxEventLoopExecuteTime = 1
    maxEventLoopExecuteTimeUnit = TimeUnit.MILLISECONDS
  }

  Vertx.vertx(options)!!.apply {
    deployVerticle(MyFirstVerticle())
  }
}
