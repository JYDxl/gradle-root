package org.github.verticle

import io.vertx.core.buffer.Buffer
import io.vertx.core.net.NetClientOptions
import io.vertx.core.net.NetServer
import io.vertx.core.net.NetServerOptions
import io.vertx.core.net.NetSocket
import io.vertx.kotlin.coroutines.CoroutineVerticle
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.toChannel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch
import org.github.ops.error
import org.github.ops.log

class NetVerticle: CoroutineVerticle() {

  private lateinit var netServer: NetServer

  override suspend fun start() {
    initNetServer()
    initBusiness()
    netServer.listen(10000).await()

    val netClient = vertx.createNetClient(NetClientOptions().apply {
      logActivity = true
      //      isSsl = true
      //      trustStoreOptions = JksOptions().apply {
      //        path = "truststore.jks"
      //        password = "654321"
      //      }
    })
    val netSocket = netClient.connect(10000, "localhost").await()
    netSocket.write(Buffer.buffer("2333")).await()
    netSocket.closeHandler {
      println("closed")
    }
  }

  private fun initNetServer() {
    netServer = vertx.createNetServer(NetServerOptions().apply {
      logActivity = true
      //      isSsl = true
      //      keyStoreOptions = JksOptions().apply {
      //        path = "keystore.jks"
      //        password = "123456"
      //      }
    })
  }

  private fun initBusiness() {
    val channel: ReceiveChannel<NetSocket> = netServer.connectStream().toChannel(vertx)
    launch {
      for(socket in channel) {
        try {
          initSocket(socket)
        } catch(e: Exception) {
          log.error(e) {}
        }
      }
    }
  }

  private suspend fun initSocket(socket: NetSocket) {
    launch { socket.pipe().endOnSuccess(false).to(socket).await() }
  }
}
