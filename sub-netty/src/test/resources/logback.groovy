appender("CONSOLE", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = "%d %5level --- [%20.20thread] %40.40logger:%-5L : %msg%n"
  }
}

root(ALL, ["CONSOLE"])
