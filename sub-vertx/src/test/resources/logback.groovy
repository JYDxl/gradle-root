import ch.qos.logback.classic.filter.ThresholdFilter

def out = "%d %5level --- [%20.20thread] %40.40logger : %msg%n"
def dir = "${System.getProperty("user.dir")}/logs/sub-vertx/"

appender("console", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = out
  }
}

appender("rollback", RollingFileAppender) {
  file = "${dir}/rollback.log"
  rollingPolicy(SizeAndTimeBasedRollingPolicy) {
    fileNamePattern = "${dir}/%d/rollback-%i.gz"
    totalSizeCap = "20GB"
    maxFileSize = "1GB"
    maxHistory = 30
  }
  encoder(PatternLayoutEncoder) {
    pattern = out
  }
}

appender("issue", FileAppender) {
  filter(ThresholdFilter) {
    level = warn
  }
  file = "${dir}/issue.log"
  encoder(PatternLayoutEncoder) {
    pattern = out
  }
}

logger("org.github", TRACE, ["issue"])
logger("io.netty", TRACE, ["issue"])
logger("io.vertx", TRACE, ["issue"])
root(DEBUG, ["console", "rollback"])
