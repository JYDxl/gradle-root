package org.github

import org.crazycake.shiro.ShiroRedisAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication(exclude = [ShiroRedisAutoConfiguration::class])
@EnableDiscoveryClient
class Web

fun main(args: Array<String>) {
  runApplication<Web>(*args)
}
