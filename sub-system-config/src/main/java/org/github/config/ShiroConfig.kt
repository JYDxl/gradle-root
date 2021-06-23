package org.github.config

import com.google.common.collect.ForwardingMap
import com.google.common.collect.ImmutableMap.of
import org.apache.shiro.authc.credential.CredentialsMatcher
import org.apache.shiro.authc.credential.HashedCredentialsMatcher
import org.apache.shiro.authz.ModularRealmAuthorizer
import org.apache.shiro.mgt.SecurityManager
import org.apache.shiro.spring.web.ShiroFilterFactoryBean
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition
import org.apache.shiro.web.filter.mgt.DefaultFilter.invalidRequest
import org.github.ops.info
import org.github.ops.log
import org.github.shiro.*
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.Collections.singletonList
import javax.servlet.Filter

@EnableConfigurationProperties(SecurityProperties::class)
@Configuration
class ShiroConfig {
  private val log = ShiroConfig::class.log

  @Suppress("ELValidationInJSP", "SpringElInspection")
  @Value("#{@environment['shiro.loginUrl']}")
  private lateinit var loginUrl: String

  @Suppress("ELValidationInJSP", "SpringElInspection")
  @Value("#{@environment['shiro-redis.cache-manager.authenSubPrefix'] ?: T(org.github.shiro.ShiroRealm).SHIRO_CACHE_KEY_AUTHEN_SUB_PREFIX}")
  private lateinit var shiroCacheKeyAuthenSubPrefix: String

  @Suppress("ELValidationInJSP", "SpringElInspection")
  @Value("#{@environment['shiro-redis.cache-manager.authorSubPrefix'] ?: T(org.github.shiro.ShiroRealm).SHIRO_CACHE_KEY_AUTHOR_SUB_PREFIX}")
  private lateinit var shiroCacheKeyAuthorSubPrefix: String

  @Autowired
  private lateinit var securityProperties: SecurityProperties

  @ConditionalOnMissingBean
  @Bean
  fun authorFunc() = DefaultAuthorFunc()

  @ConditionalOnMissingBean
  @Bean
  fun authenFunc() = DefaultAuthenFunc()

  @Bean
  fun authRealm(credentialsMatcher: CredentialsMatcher) = WEBRealm(credentialsMatcher, authorFunc(), authenFunc(), shiroCacheKeyAuthenSubPrefix, shiroCacheKeyAuthorSubPrefix)

  @Bean
  fun jwtRealm() = JWTRealm(authorFunc(), authenFunc(), shiroCacheKeyAuthenSubPrefix, shiroCacheKeyAuthorSubPrefix)

  @Bean
  fun authorizer() = ModularRealmAuthorizer()

  @Bean
  fun credentialsMatcher() = HashedCredentialsMatcher().apply {
    hashAlgorithmName = securityProperties.hashAlgorithm
    hashIterations = securityProperties.hashIterations
  }

  @Bean
  fun authenticationStrategy() = CustomFirstSuccessfulStrategy()

  @Bean
  fun passwordGenerator() = PasswordGenerator(securityProperties.hashAlgorithm, securityProperties.hashIterations)

  @Bean
  fun shiroFilterChainDefinition() = DefaultShiroFilterChainDefinition().apply {
    addPathDefinition("/swagger-resources/**", "anon")
    addPathDefinition("/swagger-ui/**", "anon")
    addPathDefinition("/v2/api-docs", "anon")
    addPathDefinition("/v3/api-docs", "anon")

    addPathDefinition("/actuator/**", "anon")

    addPathDefinition("/favicon.ico", "anon")
    addPathDefinition("/error", "anon")

    addPathDefinition("/static/**", "anon")
    addPathDefinition("/public/**", "anon")

    // addPathDefinition("/login", "authc")
    // addPathDefinition("/logout", "authc")

    addPathDefinition("/**", "authc")
  }

  @Bean
  fun sessionStorageEvaluator() = CustomWebSessionStorageEvaluator().apply {
    isSessionStorageEnabled = false
  }

  @Bean
  fun shiroFilterFactoryBean(@Suppress("SpringJavaInjectionPointsAutowiringInspection") manager: SecurityManager, definition: ShiroFilterChainDefinition) = ShiroFilterFactoryBean().apply {
    loginUrl = this@ShiroConfig.loginUrl
//    successUrl = this@ShiroConfig.successUrl
//    unauthorizedUrl = this@ShiroConfig.unauthorizedUrl
    securityManager = manager
    setGlobalFilters(singletonList(invalidRequest.name))
    filterChainDefinitionMap = definition.filterChainMap
    filters = object: ForwardingMap<String, Filter>() {
      override fun delegate(): Map<String, Filter> = of(
//        "logout", CustomLogoutFilter(),
        "authc", CustomJWTAuthenticationFilter(false),
        "perms", CustomPermissionsAuthorizationFilter(),
        "roles", CustomRolesAuthorizationFilter(),
//        "user", CustomUserFilter()
      )

      override fun put(key: String, value: Filter): Filter? = log.info {"忽略Spring中注册的的Filter[$key : $value]"}.let {null}
    }
  }

  @Bean
  fun defaultAdvisorAutoProxyCreator() = DefaultAdvisorAutoProxyCreator().apply {
    isUsePrefix = true
  }
}
