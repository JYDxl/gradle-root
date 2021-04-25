package org.github.config

import com.google.common.collect.ForwardingMap
import com.google.common.collect.ImmutableList.of
import com.google.common.collect.ImmutableMap
import org.apache.shiro.authc.credential.CredentialsMatcher
import org.apache.shiro.authc.credential.HashedCredentialsMatcher
import org.apache.shiro.authz.ModularRealmAuthorizer
import org.apache.shiro.cache.MemoryConstrainedCacheManager
import org.apache.shiro.crypto.hash.Sha256Hash.ALGORITHM_NAME
import org.apache.shiro.mgt.SecurityManager
import org.apache.shiro.spring.web.ShiroFilterFactoryBean
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition
import org.apache.shiro.web.filter.mgt.DefaultFilter.invalidRequest
import org.github.ops.debug
import org.github.ops.log
import org.github.system.shiro.*
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.servlet.Filter

@Configuration
class ShiroConfig {
  private val log = ShiroConfig::class.log

  @Value("#{ @environment['shiro.sessionManager.cookie.name'] ?: T(org.apache.shiro.web.servlet.ShiroHttpSession).DEFAULT_SESSION_ID_NAME }")
  protected lateinit var sessionIdCookieName: String

  @Value("#{ @environment['shiro.failureUrl'] ?: '/public/failure' }")
  protected lateinit var failureUrl: String

  @Value("#{ @environment['shiro.unauthorizedUrl'] ?: '/public/unauthorized' }")
  protected lateinit var unauthorizedUrl: String

  @Value("#{ @environment['shiro.logoutUrl'] ?: '/public/logout' }")
  protected lateinit var logoutUrl: String

  @Value("#{ @environment['shiro.loginUrl'] ?: '/login.jsp' }")
  protected lateinit var loginUrl: String

  @Value("#{ @environment['shiro.successUrl'] ?: '/' }")
  protected lateinit var successUrl: String

  @Bean
  fun authRealm(credentialsMatcher: CredentialsMatcher) = AuthRealm(credentialsMatcher)

  @Bean
  fun authorizer() = ModularRealmAuthorizer()

  @Bean
  fun credentialsMatcher() = HashedCredentialsMatcher().apply {
    hashAlgorithmName = ALGORITHM_NAME
    hashIterations = 1024
  }

  @Bean
  fun passwordGenerator(shiroFilterFactoryBean: ShiroFilterFactoryBean) = PasswordGenerator(ALGORITHM_NAME, 1024)

  @Bean
  fun cacheManager() = MemoryConstrainedCacheManager()

  @Bean
  fun shiroFilterChainDefinition() = DefaultShiroFilterChainDefinition().apply {
    addPathDefinition("/static/**", "anon")
    addPathDefinition("/public/**", "anon")
    addPathDefinition("/login", "authc")
    addPathDefinition("/logout", "logout")
    addPathDefinition("/rest/**", "user")
    addPathDefinition("/**", "user")
  }

  @Bean
  fun shiroFilterFactoryBean(securityManager: SecurityManager, shiroFilterChainDefinition: ShiroFilterChainDefinition): ShiroFilterFactoryBean {
    val shiroFilterFactoryBean = ShiroFilterFactoryBean()
    shiroFilterFactoryBean.loginUrl = loginUrl
    shiroFilterFactoryBean.successUrl = successUrl
    shiroFilterFactoryBean.unauthorizedUrl = unauthorizedUrl
    shiroFilterFactoryBean.securityManager = securityManager
    shiroFilterFactoryBean.setGlobalFilters(of(invalidRequest.name))
    shiroFilterFactoryBean.filterChainDefinitionMap = shiroFilterChainDefinition.filterChainMap

    shiroFilterFactoryBean.filters = object: ForwardingMap<String, Filter>() {
      override fun delegate(): Map<String, Filter> = ImmutableMap.of(
        "authc", CustomFormAuthenticationFilter(sessionIdCookieName, failureUrl, unauthorizedUrl),
        "user", CustomUserFilter(unauthorizedUrl),
        "logout", CustomLogoutFilter(logoutUrl)
      )

      override fun put(key: String, value: Filter): Filter? {
        log.debug {"忽略Spring中注册的的Filter[$key : $value]"}
        return null
      }
    }
    return shiroFilterFactoryBean
  }

  @Bean
  fun defaultAdvisorAutoProxyCreator() = DefaultAdvisorAutoProxyCreator().apply {
    isUsePrefix = true
  }
}
