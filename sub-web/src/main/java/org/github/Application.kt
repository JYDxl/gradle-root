package org.github

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
// @EnableEurekaClient
class Application

fun main(args: Array<String>) {
  runApplication<Application>(*args)
}
