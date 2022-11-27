package org.github.model

import io.vertx.core.json.Json.*

open class JsonAble {
  override fun toString() = encode(this)
}
