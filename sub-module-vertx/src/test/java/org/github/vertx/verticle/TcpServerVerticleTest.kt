package org.github.vertx.verticle

import io.vertx.core.Vertx
import io.vertx.junit5.VertxExtension
import io.vertx.junit5.VertxTestContext
import io.vertx.kotlin.coroutines.await
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(VertxExtension::class)
@TestInstance(PER_CLASS)
class TcpServerVerticleTest {
  /** vertx. */
  private lateinit var vertx: Vertx

  @BeforeAll
  fun start(ctx: VertxTestContext) = runBlocking {
    vertx = Vertx.vertx()
    vertx.deployVerticle(TcpServerVerticle()).await()
    ctx.completeNow()
  }

  @AfterAll
  fun stop(ctx: VertxTestContext) = runBlocking {
    vertx.close().await()
    ctx.completeNow()
  }

  //  @Test
  fun testApp(ctx: VertxTestContext) {
    ctx.completeNow()
  }
}
