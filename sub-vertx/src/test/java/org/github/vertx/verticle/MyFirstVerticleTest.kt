package org.github.vertx.verticle

import io.vertx.core.AsyncResult
import io.vertx.core.Vertx
import io.vertx.core.VertxOptions
import io.vertx.core.buffer.Buffer
import io.vertx.ext.unit.TestContext
import io.vertx.ext.unit.junit.VertxUnitRunner
import io.vertx.ext.web.client.HttpResponse
import io.vertx.ext.web.client.WebClient
import io.vertx.ext.web.client.WebClientOptions
import org.github.ops.error
import org.github.ops.log
import org.github.ops.warn
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit.MILLISECONDS

@RunWith(VertxUnitRunner::class)
class MyFirstVerticleTest {
  /** log. */
  private val log = MyFirstVerticleTest::class.log
  /** vertx. */
  private lateinit var vertx: Vertx

  private val port = 8000

  @Before
  fun start(ctx: TestContext) {
    val vertxOptions = VertxOptions().apply {
      maxEventLoopExecuteTimeUnit = MILLISECONDS
      maxEventLoopExecuteTime = 1
    }
    vertx = Vertx.vertx(vertxOptions)
    vertx.deployVerticle(MyFirstVerticle(port), ctx.asyncAssertSuccess())
  }

  @After
  fun stop(ctx: TestContext) {
    vertx.close(ctx.asyncAssertSuccess())
  }

  @Test
  fun testApp(ctx: TestContext) {
    val async = ctx.async()!!
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
        async.complete()
      }
  }
}
