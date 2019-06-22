appender("CONSOLE", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = "%d %5level --- [%20.20thread] %40.40logger : %msg%n"
  }
}

root(ALL, ["CONSOLE"])
