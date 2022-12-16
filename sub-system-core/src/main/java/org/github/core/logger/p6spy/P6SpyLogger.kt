package org.github.core.logger.p6spy

import com.p6spy.engine.spy.appender.MessageFormattingStrategy

class P6SpyLogger : MessageFormattingStrategy {
    override fun formatMessage(connectionId: Int, now: String, elapsed: Long, category: String, prepared: String, sql: String?, url: String): String {
        return when {
            sql.isNullOrBlank().not() -> """Consume：$elapsed ms || URL：$url || SQL：${sql!!.replace("\\s+".toRegex(), " ")}"""

            else -> ""
        }
    }
}
