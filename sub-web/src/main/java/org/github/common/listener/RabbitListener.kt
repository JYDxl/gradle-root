//package org.github.common.listener
//
//import org.github.ops.info
//import org.github.ops.log
//import org.github.ops.json
//import org.springframework.amqp.rabbit.annotation.RabbitListener
//import org.springframework.stereotype.Component
//
//@Component
//class RabbitListener {
//  /** log. */
//  private val log = RabbitListener::class.log
//
//  @RabbitListener(queues = ["app.queue"])
//  fun listen(msg: Any) {
//    log.info {msg.json()}
//  }
//}
