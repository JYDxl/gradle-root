package org.github.verticle

import io.vertx.kotlin.coroutines.CoroutineVerticle
import kotlinx.coroutines.launch
import org.github.const.Consumers.*
import org.github.model.BufferedReq
import org.github.model.BufferedRes
import org.github.model.fromBuffer
import org.github.ops.consumer
import org.github.ops.info
import org.github.ops.log
import org.github.ops.requestAwait

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
