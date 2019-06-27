package org.github.config

import io.vertx.core.Verticle
import io.vertx.core.Vertx
import org.github.vertx.verticle.MyFirstVerticle
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class VertxConfig {
  @Bean
  fun vertx(verticleList: List<Verticle>) = Vertx.vertx()!!.apply { verticleList.forEach { deployVerticle(it) } }

  @Bean
  fun myFirstVerticle() = MyFirstVerticle(8000)
}
