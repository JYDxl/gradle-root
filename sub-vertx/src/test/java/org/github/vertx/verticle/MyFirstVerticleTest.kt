package org.github.vertx.verticle

import io.vertx.core.AsyncResult
import io.vertx.core.Vertx
import io.vertx.core.VertxOptions
import io.vertx.core.buffer.Buffer
import io.vertx.ext.web.client.HttpResponse
import io.vertx.ext.web.client.WebClient
import io.vertx.ext.web.client.WebClientOptions
import io.vertx.junit5.VertxExtension
import io.vertx.junit5.VertxTestContext
import org.github.ops.error
import org.github.ops.log
import org.github.ops.warn
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.*
import org.junit.jupiter.api.extension.ExtendWith
import java.util.concurrent.TimeUnit.*

@ExtendWith(VertxExtension::class)
@TestInstance(PER_CLASS)
class MyFirstVerticleTest {
  /** log. */
  private val log = MyFirstVerticleTest::class.log
  /** vertx. */
  private lateinit var vertx: Vertx

  private val port = 8000

  @BeforeAll
  fun start(ctx: VertxTestContext) {
    val vertxOptions = VertxOptions().apply {
      maxEventLoopExecuteTimeUnit = MILLISECONDS
      maxEventLoopExecuteTime = 1
    }
    vertx = Vertx.vertx(vertxOptions)
    vertx.deployVerticle(MyFirstVerticle(port))
  }

  @AfterAll
  fun stop(ctx: VertxTestContext) {
    vertx.close()
    ctx.completeNow()
  }

  @Test
  fun testApp(ctx: VertxTestContext) {
    val webClientOptions = WebClientOptions().apply {
      logActivity = true
      isUserAgentEnabled = false
      isKeepAlive = true
    }
    val webClient = WebClient.create(vertx, webClientOptions)!!
    webClient
      .postAbs("http://localhost:$port")
      .send { ar: AsyncResult<HttpResponse<Buffer>> ->
        if(ar.failed()) {
          log.error(ar.cause()) {}
          return@send
        }
        val result: HttpResponse<Buffer> = ar.result()
        if(result.statusCode() != 200) {
          log.warn { result.statusMessage() }
          return@send
        }
        ctx.completeNow()
      }
  }
}
