def out = "%d %5level --- [%20.20thread] %40.40logger:%-5L : %msg%n"
def dir = "logs/sub-vertx/"

appender("console", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = out
  }
}

appender("file", RollingFileAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = out
  }
  rollingPolicy(TimeBasedRollingPolicy) {
    fileNamePattern = "${dir}%d/vertx.log"
  }
}

root(DEBUG, ["console", "file"])
logger("io.netty", TRACE)
logger("io.vertx", TRACE)
