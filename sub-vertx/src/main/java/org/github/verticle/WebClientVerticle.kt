package org.github.verticle

import io.vertx.ext.web.client.WebClient
import io.vertx.ext.web.client.WebClientOptions
import io.vertx.kotlin.coroutines.CoroutineVerticle
import org.github.ops.log

class WebClientVerticle: CoroutineVerticle() {
  private lateinit var webClient: WebClient

  override suspend fun start() {
    webClient = WebClient.create(vertx, WebClientOptions().apply {
      logActivity = true
      isKeepAlive = false
      defaultHost = "www.baidu.com"
    })

    // val channel = vertx.consumer<String, String>(CONSUME)
    // launch {
    //   for(msg in channel) {
    //     val value = Json.decodeValue(msg.body(), String::class.java)!!
    //     try {
    //       val res = webClient.get(value).`as`(string()).sendAwait().body()!!
    //       msg.reply(Json.encodeToBuffer(res))
    //     } catch(e: Exception) {
    //       log.error(e) { }
    //       msg.fail(-1, e.message)
    //     }
    //   }
    // }
    //
    // vertx.eventBus().send(CONSUME.toString(), "abc")
    //
    // launch {
    //   val timeChannel: ReceiveChannel<Long> = vertx.periodicStream(ofSeconds(1).toMillis()).toChannel(vertx)
    //   for(item in timeChannel) {
    //     vertx.requestAwait<String, String>(CONSUME, "")
    //   }
    // }
  }
}

private val log = WebClientVerticle::class.log
