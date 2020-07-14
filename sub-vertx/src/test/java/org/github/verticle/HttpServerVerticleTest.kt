package org.github.verticle

import io.vertx.core.Vertx
import io.vertx.core.VertxOptions
import io.vertx.ext.web.client.WebClient
import io.vertx.ext.web.client.WebClientOptions
import io.vertx.ext.web.client.predicate.ResponsePredicate.*
import io.vertx.ext.web.codec.BodyCodec.*
import io.vertx.ext.web.common.WebEnvironment.*
import io.vertx.junit5.VertxExtension
import io.vertx.junit5.VertxTestContext
import io.vertx.kotlin.core.closeAwait
import io.vertx.kotlin.ext.web.client.sendAwait
import kotlinx.coroutines.runBlocking
import org.github.ops.deploy
import org.github.ops.info
import org.github.ops.log
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.*
import org.junit.jupiter.api.extension.ExtendWith
import java.lang.System.*
import java.util.concurrent.TimeUnit.*

@ExtendWith(VertxExtension::class)
@TestInstance(PER_CLASS)
class HttpServerVerticleTest {
  /** vertx. */
  private lateinit var vertx: Vertx

  private val port = 3000

  @BeforeAll
  fun head(ctx: VertxTestContext) = runBlocking {
    setProperty(SYSTEM_PROPERTY_NAME, "dev")

    vertx = Vertx.vertx(VertxOptions().apply {
      maxEventLoopExecuteTime = 500
      maxEventLoopExecuteTimeUnit = MILLISECONDS
      preferNativeTransport = true
    })
    vertx.deploy(HttpServerVerticle(port))
    ctx.completeNow()
  }

  @AfterAll
  fun tail(ctx: VertxTestContext) = runBlocking {
    vertx.closeAwait()
    ctx.completeNow()
  }

  @Test
  fun test(ctx: VertxTestContext) = runBlocking {
    val webClientOptions = WebClientOptions().apply { logActivity = true }
    val webClient = WebClient.create(vertx, webClientOptions)
    val res = webClient
      .getAbs("http://www.baidu.com")
      .expect(SC_OK)
      .`as`(string())
      .sendAwait()
      .body()
    log.info { res }
    ctx.completeNow()
  }
}

private val log = HttpServerVerticleTest::class.log
