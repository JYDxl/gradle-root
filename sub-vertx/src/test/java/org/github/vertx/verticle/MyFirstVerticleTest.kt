package org.github.vertx.verticle

import io.vertx.core.Vertx
import io.vertx.core.http.HttpClientResponse
import io.vertx.ext.unit.TestContext
import io.vertx.ext.unit.junit.VertxUnitRunner
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(VertxUnitRunner::class)
class MyFirstVerticleTest {
  /** vertx. */
  private lateinit var vertx: Vertx

  @Before
  fun setUp(ctx: TestContext) {
    vertx = Vertx.vertx()
    vertx.deployVerticle(MyFirstVerticle(), ctx.asyncAssertSuccess())
  }

  @After
  fun tearDown(ctx: TestContext) {
    vertx.close(ctx.asyncAssertSuccess())
  }

  @Test
  fun testApp(ctx: TestContext) {
    val async = ctx.async()!!
    @Suppress("DEPRECATION")
    vertx.createHttpClient().get(10000, "localhost", "/some/path") { resp: HttpClientResponse ->
      ctx.assertTrue(resp.statusCode() == 200)
      async.complete()
    }
  }
}
