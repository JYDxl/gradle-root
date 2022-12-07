package org.github.vertx.verticle

import io.vertx.kotlin.coroutines.CoroutineVerticle
import kotlinx.coroutines.launch
import org.github.vertx.const.Consumers.*
import org.github.vertx.model.BufferedReq
import org.github.vertx.model.BufferedRes
import org.github.vertx.model.fromBuffer
import org.github.vertx.ops.consumer
import org.github.core.ops.info
import org.github.core.ops.log
import org.github.vertx.ops.requestAwait

class BufferVerticle: CoroutineVerticle() {
  override suspend fun start() {
    initConsumer()
    initProducer()
  }

  private suspend fun initProducer() {
    val req = BufferedReq().apply {
      cmd = "2333"
      params = "idea"
    }
    val (_, res) = vertx.requestAwait<BufferedReq, BufferedRes>(BUFFER, req)
    log.info { res }
  }

  private fun initConsumer() {
    val channel = vertx.consumer<BufferedReq, BufferedRes>(BUFFER)
    launch {
      for(message in channel) {
        val req = fromBuffer<BufferedReq>(message.body())
        val res = BufferedRes().apply {
          cmd = req.cmd
          result = req.params.uppercase()
        }
          .toBuffer()
        message.reply(res)
      }
    }
  }
}

private val log = BufferVerticle::class.log
