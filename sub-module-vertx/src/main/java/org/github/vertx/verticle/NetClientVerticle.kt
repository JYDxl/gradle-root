package org.github.vertx.verticle

import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufUtil.*
import io.netty.util.ByteProcessor.*
import io.vertx.core.buffer.Buffer
import io.vertx.core.buffer.Buffer.*
import io.vertx.core.net.NetClient
import io.vertx.core.net.NetClientOptions
import io.vertx.kotlin.coroutines.CoroutineVerticle
import io.vertx.kotlin.coroutines.await
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.github.core.ops.info
import org.github.vertx.ops.log
import java.nio.charset.StandardCharsets.*
import java.util.concurrent.TimeUnit.*

class NetClientVerticle(private val host: String, private val port: Int): CoroutineVerticle() {

  private lateinit var netClient: NetClient

  private var buffer: Buffer = buffer()

  override suspend fun start() {
    initNetClient()
    initNetClientBusiness()
  }

  private fun initNetClient() {
    val netClientOptions = NetClientOptions().apply {
      logActivity = true
    }
    netClient = vertx.createNetClient(netClientOptions)
  }

  private suspend fun initNetClientBusiness() {
    val socket = netClient.connect(port, host).await()
    log.info { "handlerID: ${socket.writeHandlerID()}" }
    socket.handler { buf: Buffer ->
      launch {
        buffer = buffer.appendBuffer(buf)
        while(true) {
          val byteBuf = buffer.byteBuf
          val index = byteBuf.forEachByte(FIND_LF)
          if(index == -1) return@launch
          val data = byteBuf.readSlice(index + 1)
          buffer = buffer(getBytes(byteBuf))
          handle(data)
        }
      }
    }
    socket.closeHandler { _: Void? ->
      launch {
        while(true) {
          try {
            initNetClientBusiness()
            return@launch
          } catch(e: Exception) {
            e.printStackTrace()
            delay(SECONDS.toMillis(1))
          }
        }
      }
    }
  }

  private fun handle(buf: ByteBuf) {
    println(buf.toString(UTF_8))
  }
}
