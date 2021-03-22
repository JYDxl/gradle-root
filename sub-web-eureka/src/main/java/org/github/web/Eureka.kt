package org.github.web

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import java.lang.Exception

@SpringBootApplication
@EnableEurekaServer
class Eureka {
  @Configuration
  class SecurityPermitAllConfig: WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
      http.authorizeRequests().anyRequest().permitAll().and().csrf().disable()
    }
  }
}

fun main(args: Array<String>) {
  runApplication<Eureka>(*args)
}
