package org.github

import kotlinx.coroutines.runBlocking
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
// @EnableEurekaClient
class Application

fun main(args: Array<String>) = runBlocking<Unit> {
  runApplication<Application>(*args).apply {}
}
