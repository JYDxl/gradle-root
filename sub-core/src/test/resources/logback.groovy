def out = "%d %5level --- [%50.50thread] %40.40logger : %msg%n"

appender("console", ConsoleAppender) {
  encoder(PatternLayoutEncoder) { pattern = out }
}

logger("org.github", TRACE)
logger("io.netty", TRACE)
root(INFO, ["console"])
