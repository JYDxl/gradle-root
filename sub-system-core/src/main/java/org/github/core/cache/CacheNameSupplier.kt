package org.github.core.cache

import java.util.function.UnaryOperator

interface CacheNameSupplier: UnaryOperator<String> {
  override fun apply(prefix: String): String {
    return prefix + this
  }
}
