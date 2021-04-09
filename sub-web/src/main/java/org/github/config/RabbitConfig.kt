//package org.github.config
//
//import org.github.spring.rabbit.RabbitMessageConverter
//import org.springframework.amqp.core.Binding
//import org.springframework.amqp.core.BindingBuilder
//import org.springframework.amqp.core.Queue
//import org.springframework.amqp.core.TopicExchange
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//
//@Configuration
//class RabbitConfig {
//  @Bean
//  fun topicExchange() = TopicExchange("app.topic")
//
//  @Bean
//  fun queue() = Queue("app.queue")
//
//  @Bean
//  fun binding(): Binding = BindingBuilder.bind(queue()).to(topicExchange()).with("#")
//
//  @Bean
//  fun rabbitMessageConverter() = RabbitMessageConverter()
//}
