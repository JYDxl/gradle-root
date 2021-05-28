package org.github

import org.crazycake.shiro.ShiroRedisAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication(exclude = [ShiroRedisAutoConfiguration::class])
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
class Web

fun main(args: Array<String>) {
  runApplication<Web>(*args)
}
