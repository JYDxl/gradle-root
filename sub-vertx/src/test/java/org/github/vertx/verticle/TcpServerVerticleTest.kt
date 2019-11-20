package org.github.vertx.verticle

import io.vertx.core.Vertx
import io.vertx.junit5.VertxExtension
import io.vertx.junit5.VertxTestContext
import io.vertx.kotlin.core.closeAwait
import io.vertx.kotlin.core.deployVerticleAwait
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.*
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(VertxExtension::class)
@TestInstance(PER_CLASS)
class TcpServerVerticleTest {
  /** vertx. */
  private lateinit var vertx: Vertx

  @BeforeAll
  fun start(ctx: VertxTestContext) = runBlocking {
    vertx = Vertx.vertx()
    vertx.deployVerticleAwait(TcpServerVerticle())
    ctx.completeNow()
  }

  @AfterAll
  fun stop(ctx: VertxTestContext) = runBlocking {
    vertx.closeAwait()
    ctx.completeNow()
  }

  @Test
  fun testApp(ctx: VertxTestContext) {
    ctx.completeNow()
  }
}
