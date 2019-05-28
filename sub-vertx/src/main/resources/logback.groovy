appender("CONSOLE", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = "%d %5level [%20.20thread] %37.37logger{5}:%-4L -- %msg%n"
  }
}

root(ALL, ["CONSOLE"])
