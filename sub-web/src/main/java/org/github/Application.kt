package org.github

import org.github.mybatis.MyBatisMapper
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@MapperScan("org.github", annotationClass = MyBatisMapper::class)
@SpringBootApplication
@EnableEurekaClient
class Application

fun main(args: Array<String>) {
  runApplication<Application>(*args)
}
