package org.github

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
  val context = runApplication<Application>(*args)
  val amqpTemplate = context.getBean(AmqpTemplate::class.java)
  amqpTemplate.convertAndSend("app.queue", User("admin", "admin"))
  amqpTemplate.convertAndSend("app.queue", User("root", "root"))
}
