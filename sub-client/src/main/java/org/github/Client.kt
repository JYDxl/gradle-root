package org.github

import org.crazycake.shiro.ShiroRedisAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication(exclude = [ShiroRedisAutoConfiguration::class])
@EnableDiscoveryClient
@EnableFeignClients
class Client

fun main(args: Array<String>) {
  runApplication<Client>(*args)
}
