package org.github.vertx.verticle

import io.vertx.core.Vertx
import io.vertx.ext.unit.TestContext
import io.vertx.ext.unit.junit.VertxUnitRunner
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(VertxUnitRunner::class)
class TcpServerVerticleTest {
  /** vertx. */
  private lateinit var vertx: Vertx

  @Before
  fun start(ctx: TestContext) {
    vertx = Vertx.vertx()
    vertx.deployVerticle(TcpServerVerticle(), ctx.asyncAssertSuccess())
  }

  @After
  fun stop(ctx: TestContext) {
    vertx.close(ctx.asyncAssertSuccess())
  }

  @Test
  fun testApp(ctx: TestContext) {
    val async = ctx.async()!!
    async.complete()
  }
}
