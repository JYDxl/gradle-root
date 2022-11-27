package org.github

import io.vertx.core.DeploymentOptions
import io.vertx.core.Vertx
import io.vertx.core.VertxOptions
import io.vertx.ext.web.common.WebEnvironment.SYSTEM_PROPERTY_NAME
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.github.ops.deploySupplier
import org.github.verticle.WebSocketServerVerticle
import java.lang.System.setProperty

suspend fun main() = coroutineScope {
  setProperty(SYSTEM_PROPERTY_NAME, "dev")

  //配置vertx
  val vertxOptions = VertxOptions().apply {
    workerPoolSize = eventLoopPoolSize * 2
    internalBlockingPoolSize = workerPoolSize
    maxEventLoopExecuteTime = maxWorkerExecuteTime
    preferNativeTransport = true
  }
  val vertx = Vertx.vertx(vertxOptions)

  //注册自定义编解码器
  // vertx.eventBus().apply {
  //   registerDefaultCodec(EduScore::class.java, EduScoreCodec())
  // }

  //部署多个实例
  val deploymentOptions = DeploymentOptions().apply {instances = vertxOptions.eventLoopPoolSize}
  //  launch { vertx.deploySupplier(Supplier { HttpServerVerticle() }, HttpServerVerticle::class, deploymentOptions) }
  //  launch { vertx.deploy(MySqlVerticle(), MySqlVerticle::class) }
  //  launch { vertx.deploy(WebClientVerticle()) }
  //部署单个实例
  //  vertx.deploy(FileServerVerticle())
  //  vertx.deploy(AsyncVerticle())
  // launch { vertx.deploy(HttpServerVerticle()) }
  launch {vertx.deploySupplier({WebSocketServerVerticle()}, deploymentOptions)}
  // launch { vertx.deploy(NetClientVerticle("docker.for.mac.localhost", 10000)) }
  //    launch { vertx.deploySupplier(Supplier { NetClientVerticle("localhost", 3000) }, deploymentOptions) }
  return@coroutineScope
}
