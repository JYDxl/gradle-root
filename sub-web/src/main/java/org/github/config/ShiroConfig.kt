package org.github.config

import com.google.common.collect.ForwardingMap
import com.google.common.collect.ImmutableMap.of
import org.apache.shiro.authc.credential.CredentialsMatcher
import org.apache.shiro.authc.credential.HashedCredentialsMatcher
import org.apache.shiro.authz.ModularRealmAuthorizer
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
import java.util.Collections.singletonList
import javax.servlet.Filter

@Configuration
class ShiroConfig {
  private val log = ShiroConfig::class.log

  @Value("#{@environment['shiro.sessionManager.cookie.name']}")
  protected lateinit var sessionIdCookieName: String

  @Value("#{@environment['shiro.failureUrl']}")
  protected lateinit var failureUrl: String

  @Value("#{@environment['shiro.unauthorizedUrl']}")
  protected lateinit var unauthorizedUrl: String

  @Value("#{@environment['shiro.logoutUrl']}")
  protected lateinit var logoutUrl: String

  @Value("#{@environment['shiro.loginUrl']}")
  protected lateinit var loginUrl: String

  @Value("#{@environment['shiro.successUrl']}")
  protected lateinit var successUrl: String

  @Bean
  fun authRealm(credentialsMatcher: CredentialsMatcher) = AuthRealm(credentialsMatcher)

  @Bean
  fun authorizer() = ModularRealmAuthorizer()

  @Bean
  fun credentialsMatcher() = HashedCredentialsMatcher().apply {
    hashAlgorithmName = ALGORITHM_NAME
    hashIterations = 2
  }

  @Bean
  fun passwordGenerator() = PasswordGenerator(ALGORITHM_NAME, 2)

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
  fun sessionStorageEvaluator() = CustomWebSessionStorageEvaluator().apply {
    isSessionStorageEnabled = false
  }

  @Bean
  fun shiroFilterFactoryBean(manager: SecurityManager, definition: ShiroFilterChainDefinition) = ShiroFilterFactoryBean().apply {
    loginUrl = this@ShiroConfig.loginUrl
    successUrl = this@ShiroConfig.successUrl
    unauthorizedUrl = this@ShiroConfig.unauthorizedUrl
    securityManager = manager
    setGlobalFilters(singletonList(invalidRequest.name))
    filterChainDefinitionMap = definition.filterChainMap
    filters = object: ForwardingMap<String, Filter>() {
      override fun delegate(): Map<String, Filter> = of(
        "authc", CustomFormAuthenticationFilter(this@ShiroConfig.sessionIdCookieName, this@ShiroConfig.failureUrl, this@ShiroConfig.unauthorizedUrl),
        "user", CustomUserFilter(this@ShiroConfig.unauthorizedUrl),
        "logout", CustomLogoutFilter(this@ShiroConfig.logoutUrl)
      )

      override fun put(key: String, value: Filter): Filter? = log.debug {"忽略Spring中注册的的Filter[$key : $value]"}.let {null}
    }
  }

  @Bean
  fun defaultAdvisorAutoProxyCreator() = DefaultAdvisorAutoProxyCreator().apply {
    isUsePrefix = true
  }
}
