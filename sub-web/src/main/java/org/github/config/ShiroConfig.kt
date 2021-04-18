package org.github.config

import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition
import org.github.system.shiro.AuthRealm
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ShiroConfig {
  @Bean
  fun authorizer() = AuthRealm()

  @Bean
  fun shiroFilterChainDefinition() = DefaultShiroFilterChainDefinition().apply {
    addPathDefinition("/**", "anon")
  }
}
