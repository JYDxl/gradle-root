package org.github.ws

import io.vertx.core.Vertx
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.ServerWebSocket
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.github.ops.*

class ServerWebSocketProxy(ws: ServerWebSocket, vertx: Vertx): CoroutineScope, ServerWebSocket by ws {
  override val coroutineContext by lazy { vertx.dispatcher() }

  fun coroutineExceptionHandler(handle: CoroutineVertxServerWebSocketHandler<Throwable>): ServerWebSocket {
    val fn = handle.name
    exceptionHandler { throwable: Throwable ->
      launch(CoroutineName(fn)) {
        log.trace { "Touch exceptionHandler $fn" }
        try {
          handle(this@ServerWebSocketProxy, throwable)
        } catch(e: Exception) {
          log.error(e) {}
        } finally {
          log.trace { "Leave exceptionHandler $fn" }
        }
      }
    }
    return this
  }

  fun coroutineTextMessageHandler(handle: CoroutineVertxServerWebSocketHandler<String>): ServerWebSocket {
    val fn = handle.name
    textMessageHandler { text: String ->
      launch(CoroutineName(fn)) {
        log.trace { "Touch textMessageHandler $fn" }
        try {
          handle(this@ServerWebSocketProxy, text)
        } catch(e: Exception) {
          log.error(e) {}
        } finally {
          log.trace { "Leave textMessageHandler $fn" }
        }
      }
    }
    return this
  }

  fun coroutineBinaryMessageHandler(handle: CoroutineVertxServerWebSocketHandler<Buffer>): ServerWebSocket {
    val fn = handle.name
    binaryMessageHandler { buffer: Buffer ->
      launch(CoroutineName(fn)) {
        log.trace { "Touch binaryMessageHandler $fn" }
        try {
          handle(this@ServerWebSocketProxy, buffer)
        } catch(e: Exception) {
          log.error(e) {}
        } finally {
          log.trace { "Leave binaryMessageHandler $fn" }
        }
      }
    }
    return this
  }

  fun coroutineCloseHandler(handle: CoroutineVertxServerWebSocketHandler<Unit>): ServerWebSocket {
    val fn = handle.name
    closeHandler { _: Void? ->
      launch(CoroutineName(fn)) {
        log.trace { "Touch closeHandler $fn" }
        try {
          handle(this@ServerWebSocketProxy, Unit)
        } catch(e: Exception) {
          log.error(e) {}
        } finally {
          log.trace { "Leave closeHandler $fn" }
        }
      }
    }
    return this
  }
}

private val log = ServerWebSocketProxy::class.log
