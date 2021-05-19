def out = "%d [%5level] --- [%25.25thread] %-30.30logger{30} : %msg%n"

appender("console", ConsoleAppender) {
  encoder(PatternLayoutEncoder) { pattern = out }
}

logger("org.github", TRACE)
root(DEBUG, ["console"])
