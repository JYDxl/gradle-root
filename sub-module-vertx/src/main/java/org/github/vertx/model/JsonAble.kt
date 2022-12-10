package org.github.vertx.model

import io.vertx.core.json.Json.encode

open class JsonAble {
  override fun toString(): String = encode(this)
}
