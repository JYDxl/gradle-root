package org.github.common.config

import cn.dev33.satoken.`fun`.SaFunction
import cn.dev33.satoken.interceptor.SaInterceptor
import cn.dev33.satoken.jwt.SaJwtUtil.createToken
import cn.dev33.satoken.jwt.StpLogicJwtForSimple
import cn.dev33.satoken.router.SaRouter.notMatch
import cn.dev33.satoken.stp.StpUtil.checkLogin
import com.google.common.collect.ImmutableList.builder
import com.google.common.collect.ImmutableList.of
import javax.annotation.Resource
import org.github.core.LOGIN_TYPE_NAME
import org.github.core.props.DynamicProperties
import org.github.core.spring.mvc.ReturnableValueHandlerKotlin
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodReturnValueHandler
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter

@Configuration
class WebMvcConfigWithSaToken: WebMvcConfigurer {
  @Resource
  private lateinit var dynamicProperties: DynamicProperties

  override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
    registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/")
  }

  @Bean
  fun returnableValueHandler(adapter: RequestMappingHandlerAdapter) = ReturnableValueHandlerKotlin.apply {
    adapter.returnValueHandlers = builder<HandlerMethodReturnValueHandler>().add(this).addAll(adapter.returnValueHandlers ?: of()).build()
  }

  @Bean
  fun stpLogicJwt() = object: StpLogicJwtForSimple(LOGIN_TYPE_NAME) {
    override fun createTokenValue(loginId: Any, device: String, timeout: Long, extraData: MutableMap<String, Any>?): String {
      return createToken(loginType, loginId, device, timeout, extraData, jwtSecretKey())
    }
  }

  override fun addInterceptors(registry: InterceptorRegistry) {
    registry.addInterceptor(SaInterceptor {notMatch(dynamicProperties.whiteList).check(SaFunction {checkLogin()})}).addPathPatterns("/**")
  }
}
