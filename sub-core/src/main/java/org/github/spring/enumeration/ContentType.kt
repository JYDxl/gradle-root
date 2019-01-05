package org.github.spring.enumeration

import java.util.function.Supplier

/**
 * Content Type.
 *
 * @author JYD_XL
 */
enum class ContentType(private val content: String) : Supplier<String> {
  BIN("application/octet-stream"),

  TEXT("text/plain"),

  JSON("application/json"),

  JSONP("application/javascript");

  override fun get() = content
}
