package org.github.verticle

import io.vertx.core.eventbus.Message
import io.vertx.kotlin.coroutines.CoroutineVerticle
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.toReceiveChannel
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.github.ops.info
import org.github.ops.log
import java.time.Duration

class AsyncVerticle: CoroutineVerticle() {
  override suspend fun start() {
    val eventBus = vertx.eventBus()
    val channel: ReceiveChannel<Message<String>> = eventBus
      .localConsumer<String>("a.b.c")
      .setMaxBufferedMessages(Int.MAX_VALUE)
      .toReceiveChannel(vertx)
    launch {
      for (msg in channel) {
        launch {
          val body = msg.body()
          log.info {body}
          delay(500)
          msg.reply(body)
        }
      }
    }
    launch {
      val timeChannel: ReceiveChannel<Long> =
        vertx.periodicStream(Duration.ofSeconds(1).toMillis()).toReceiveChannel(vertx)
      for (ignore in timeChannel) {
        repeat(100_000) {
          launch(Default) {
            eventBus.request<String>(
              "a.b.c",
              "2333+${System.currentTimeMillis()}"
            ).await()
          }
        }
      }
    }
  }
}
