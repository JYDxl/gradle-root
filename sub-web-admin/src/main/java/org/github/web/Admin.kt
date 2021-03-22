package org.github.web

import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import java.lang.Exception


@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
class Admin {
  @Configuration
  class SecurityPermitAllConfig: WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
      http.authorizeRequests().anyRequest().permitAll().and().csrf().disable()
    }
  }
}

fun main(args: Array<String>) {
  runApplication<Admin>(*args)
}
