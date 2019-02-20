package org.github.spring.enumerate

/**
 * Content Type.
 *
 * @author JYD_XL
 */
enum class ContentType(private val contentType: String) {
  BIN("application/octet-stream;charset=UTF-8"),

  TEXT("text/plain;charset=UTF-8"),

  HTML("text/html;charset=UTF-8"),

  JSON("application/json;charset=UTF-8"),

  JSONP("application/javascript;charset=UTF-8");

  override fun toString() = contentType
}
