package org.github

import io.vertx.core.DeploymentOptions
import io.vertx.core.Vertx
import io.vertx.core.VertxOptions
import org.github.vertx.verticle.MyFirstVerticle
import java.util.concurrent.TimeUnit

fun main() {
  val vertxOptions = VertxOptions().apply {
    maxEventLoopExecuteTime = 1
    maxEventLoopExecuteTimeUnit = TimeUnit.SECONDS
  }

  val vertx = Vertx.vertx(vertxOptions)!!

  val deploymentOptions = DeploymentOptions().apply {
    instances = 8
  }

  vertx.deployVerticle(MyFirstVerticle::class.java, deploymentOptions)
}
