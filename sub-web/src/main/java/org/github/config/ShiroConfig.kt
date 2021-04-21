package org.github.config

import org.apache.shiro.authz.ModularRealmAuthorizer
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition
import org.github.system.shiro.AuthRealm
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ShiroConfig {
  @Bean
  fun authRealm() = AuthRealm()

  @Bean
  fun authorizer() = ModularRealmAuthorizer()

  @Bean
  fun shiroFilterChainDefinition() = DefaultShiroFilterChainDefinition().apply {
    addPathDefinition("/**", "anon")
  }

  @Bean
  fun defaultAdvisorAutoProxyCreator() = DefaultAdvisorAutoProxyCreator().apply {
    isUsePrefix = true
  }
}
