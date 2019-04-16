package org.github.extra

import com.p6spy.engine.spy.appender.MessageFormattingStrategy

class P6SpyLogger: MessageFormattingStrategy {
  override fun formatMessage(connectionId: Int, now: String?, elapsed: Long, category: String?, prepared: String?, sql: String?, url: String?) = if(sql != null) "Consume Time: ${"${elapsed}ms".padStart(6, ' ')} | url: $url \n  Execute SQL: ${sql.replace("\\s+".toRegex(), " ")}" else null
}
