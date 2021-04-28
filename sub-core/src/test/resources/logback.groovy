def out = "%d %5level --- [%50.50thread] %40.40logger : %msg%n"

appender("console", ConsoleAppender) {
  encoder(PatternLayoutEncoder) { pattern = out }
}

root(TRACE, ["console"])
