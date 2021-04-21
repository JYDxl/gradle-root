package org.github.config

import org.apache.shiro.authc.credential.CredentialsMatcher
import org.apache.shiro.authc.credential.HashedCredentialsMatcher
import org.apache.shiro.authz.ModularRealmAuthorizer
import org.apache.shiro.cache.MemoryConstrainedCacheManager
import org.apache.shiro.crypto.hash.Sha256Hash
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition
import org.github.system.shiro.AuthRealm
import org.github.system.shiro.PasswordGenerator
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ShiroConfig {
  @Bean
  fun authRealm(credentialsMatcher: CredentialsMatcher) = AuthRealm(credentialsMatcher)

  @Bean
  fun authorizer() = ModularRealmAuthorizer()

  @Bean
  fun credentialsMatcher() = HashedCredentialsMatcher().apply {
    hashAlgorithmName = Sha256Hash.ALGORITHM_NAME
    hashIterations = 1024
  }

  @Bean
  fun passwordGenerator() = PasswordGenerator(Sha256Hash.ALGORITHM_NAME, 1024)

  @Bean
  fun cacheManager() = MemoryConstrainedCacheManager()

  @Bean
  fun shiroFilterChainDefinition() = DefaultShiroFilterChainDefinition().apply {
    addPathDefinition("/**", "authc")
  }

  @Bean
  fun defaultAdvisorAutoProxyCreator() = DefaultAdvisorAutoProxyCreator().apply {
    isUsePrefix = true
  }
}
