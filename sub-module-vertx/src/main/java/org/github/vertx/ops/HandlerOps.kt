package org.github.vertx.ops

import io.vertx.core.Promise
import io.vertx.core.http.ServerWebSocket
import io.vertx.ext.web.RoutingContext

typealias CoroutineVertxRouteHandler = suspend (RoutingContext) -> Unit

typealias CoroutineVertxServerWebSocketHandler<T> = suspend (ServerWebSocket, T) -> Unit

typealias BlockingCodeHandler<T> = (Promise<T>) -> Unit

val Function<*>.name
  get() = toString().split('(', limit = 2)[0].takeLast(31).let {
    if(it.isBlank()) toString() else it
  }
