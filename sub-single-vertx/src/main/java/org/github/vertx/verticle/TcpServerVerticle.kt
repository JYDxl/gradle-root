package org.github.vertx.verticle

import io.vertx.core.AbstractVerticle
import io.vertx.core.AsyncResult
import io.vertx.core.buffer.Buffer
import io.vertx.core.net.NetServer
import io.vertx.core.net.NetServerOptions
import io.vertx.core.net.NetSocket
import org.github.ops.info
import org.github.ops.log

class TcpServerVerticle: AbstractVerticle() {

  private val log = TcpServerVerticle::class.log

  private lateinit var netServer: NetServer

  override fun start() {
    val netServerOptions = NetServerOptions().apply {
      this.port = 9876
      this.acceptBacklog = 1024
      this.logActivity = true
    }
    netServer = vertx.createNetServer(netServerOptions)
    netServer.connectHandler { socket: NetSocket ->
      socket.handler { _: Buffer ->
      }
    }
    netServer.listen { result: AsyncResult<NetServer> ->
      log.info { result }
    }
  }
}
