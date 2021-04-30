package org.github

import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients(basePackages = ["org.github.api.module.web.system"])
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
class Admin

fun main(args: Array<String>) {
  runApplication<Admin>(*args)
}
