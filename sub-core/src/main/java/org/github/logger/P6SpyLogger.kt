package org.github.logger

import com.p6spy.engine.spy.appender.MessageFormattingStrategy

class P6SpyLogger: MessageFormattingStrategy {
  override fun formatMessage(connectionId: Int, now: String, elapsed: Long, category: String, prepared: String, sql: String, url: String) = sql.let {
    """Consume Time: ${"$elapsed".padStart(4, ' ')}ms | url: $url
      | Execute SQL: ${it.replace("\\s+".toRegex(), " ")}
    """.trimMargin()
  }
}
