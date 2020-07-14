import ch.qos.logback.classic.filter.ThresholdFilter

def out = "%d %5level --- [%50.50thread] %40.40logger : %msg%n"
def dir = "build/logs/sub-vertx"

appender("console", ConsoleAppender) {
  encoder(PatternLayoutEncoder) { pattern = out }
}

appender("records", RollingFileAppender) {
  file = "${dir}/records.txt"
  rollingPolicy(SizeAndTimeBasedRollingPolicy) {
    fileNamePattern = "${dir}/%d/records-%i.gz"
    totalSizeCap = "20GB"
    maxFileSize = "1GB"
    maxHistory = 30
  }
  encoder(PatternLayoutEncoder) { pattern = out }
}

appender("problem", RollingFileAppender) {
  file = "${dir}/problem.txt"
  rollingPolicy(SizeAndTimeBasedRollingPolicy) {
    fileNamePattern = "${dir}/%d/problem-%i.gz"
    totalSizeCap = "20GB"
    maxFileSize = "1GB"
    maxHistory = 30
  }
  filter(ThresholdFilter) { level = warn }
  encoder(PatternLayoutEncoder) { pattern = out }
}

logger("org.github", TRACE)
logger("io.netty", TRACE)
logger("io.vertx", TRACE)
logger("io.netty.util.internal.NativeLibraryLoader", INFO)
root(INFO, ["console", "records", "problem"])
