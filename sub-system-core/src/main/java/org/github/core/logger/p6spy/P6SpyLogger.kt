package org.github.core.logger.p6spy;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class P6SpyLogger implements MessageFormattingStrategy {
  @Override
  public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
    return isNotBlank(sql) ? "Consume Time：" + elapsed + " ms\n   JDBC URL：" + url + "\nExecute SQL：" + sql.replaceAll("\\s+", " ") + "\n" : "";
  }
}
