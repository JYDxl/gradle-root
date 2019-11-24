package org.github.verticle

import io.vertx.core.buffer.Buffer
import io.vertx.core.net.NetClientOptions
import io.vertx.core.net.NetServer
import io.vertx.core.net.NetServerOptions
import io.vertx.core.net.NetSocket
import io.vertx.kotlin.core.net.connectAwait
import io.vertx.kotlin.core.net.listenAwait
import io.vertx.kotlin.core.net.writeAwait
import io.vertx.kotlin.core.streams.toAwait
import io.vertx.kotlin.coroutines.CoroutineVerticle
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
    netServer.listenAwait(10000)

    val netClient = vertx.createNetClient(NetClientOptions().apply {
      logActivity = true
//      isSsl = true
//      trustStoreOptions = JksOptions().apply {
//        path = "truststore.jks"
//        password = "654321"
//      }
    })!!
    val netSocket = netClient.connectAwait(10000, "localhost")
    netSocket.writeAwait(Buffer.buffer("2333"))
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
    launch { socket.pipe().endOnSuccess(false).toAwait(socket) }
  }
}

private val log = NetVerticle::class.log
