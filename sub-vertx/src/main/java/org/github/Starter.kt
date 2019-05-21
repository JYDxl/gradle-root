package org.github

import io.vertx.core.Vertx
import org.github.vertx.verticle.MyFirstVerticle

fun main() {
  Vertx.vertx()!!.apply {
    deployVerticle(MyFirstVerticle())
  }
}
