package org.github

import org.github.config.ShiroConfig
import org.github.config.ShiroRedisConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScan.Filter
import org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE

@ComponentScan(excludeFilters = [Filter(type = ASSIGNABLE_TYPE, classes = [ShiroConfig::class, ShiroRedisConfig::class])])
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
class Blog

fun main(args: Array<String>) {
  runApplication<Blog>(*args)
}
