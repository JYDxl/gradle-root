package org.github.verticle

import io.netty.handler.codec.http.websocketx.WebSocketCloseStatus.*
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpServer
import io.vertx.core.http.HttpServerOptions
import io.vertx.core.http.ServerWebSocket
import io.vertx.kotlin.coroutines.CoroutineVerticle
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.toChannel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch
import org.github.ops.error
import org.github.ops.info
import org.github.ops.log
import org.github.ops.warn
import org.github.ws.ServerWebSocketProxy

class WebSocketServerVerticle(private val port: Int = 8800): CoroutineVerticle() {

  private lateinit var httpServer: HttpServer

  override suspend fun start() {
    initHttpServer()
    initWebSocketServer()
    httpServer.listen(port).await()
    log.info { "websocket服务端[:$port]启动成功" }
  }

  private fun initHttpServer() {
    val httpServerOptions = HttpServerOptions().apply {
      logActivity = true
    }
    httpServer = vertx.createHttpServer(httpServerOptions)
  }

  private suspend fun initWebSocketServer() {
    val channel: ReceiveChannel<ServerWebSocket> = httpServer.webSocketStream().toChannel(vertx)
    launch {
      for(ws in channel) {
        //握手
        if(!wsHandShake(ws)) continue
        //设置处理器
        ServerWebSocketProxy(ws, vertx).apply {
          coroutineExceptionHandler(::wsExceptionHandler)
          coroutineBinaryMessageHandler(::wsBinaryMessageHandler)
          coroutineTextMessageHandler(::wsTextMessageHandler)
          coroutineCloseHandler(::wsCloseHandler)
        }
      }
    }
  }

  private suspend fun wsCloseHandler(ws: ServerWebSocket, @Suppress("UNUSED_PARAMETER") unit: Unit) {
    log.info { "websocket客户端[${ws.remoteAddress()}]已关闭" }
    log.info { "websocket客户端[${ws.remoteAddress()}]已注销 textHandler:${ws.textHandlerID()} | binaryHandler:${ws.binaryHandlerID()}" }
  }

  private suspend fun wsTextMessageHandler(ws: ServerWebSocket, msg: String) {
    log.info { "从websocket客户端[${ws.remoteAddress()}]接收到文本数据: $msg" }
    ws.writeTextMessage(msg.toUpperCase()).await()
  }

  private suspend fun wsBinaryMessageHandler(ws: ServerWebSocket, buf: Buffer) {
    log.info { "从websocket客户端[${ws.remoteAddress()}]接收到二进制数据: " }
    ws.writeBinaryMessage(buf).await()
  }

  private suspend fun wsHandShake(ws: ServerWebSocket): Boolean {
    return try {
      //TODO: implement
      ws.accept()
      log.info { "websocket客户端[${ws.remoteAddress()}]握手成功" }
      log.info { "websocket客户端[${ws.remoteAddress()}]已注册 textHandler:${ws.textHandlerID()} | binaryHandler:${ws.binaryHandlerID()}" }
      true
    } catch(e: Exception) {
      ws.reject()
      log.warn(e) { "websocket客户端[${ws.remoteAddress()}]握手失败" }
      false
    }
  }

  private suspend fun wsExceptionHandler(ws: ServerWebSocket, e: Throwable) {
    log.error(e) {}
    ws.close(INTERNAL_SERVER_ERROR.code().toShort(), INTERNAL_SERVER_ERROR.reasonText()).await()
  }
}

private val log = WebSocketServerVerticle::class.log
