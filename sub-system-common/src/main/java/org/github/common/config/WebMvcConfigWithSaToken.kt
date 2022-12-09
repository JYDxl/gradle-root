package org.github.common.config

import cn.dev33.satoken.`fun`.SaFunction
import cn.dev33.satoken.interceptor.SaInterceptor
import cn.dev33.satoken.jwt.StpLogicJwtForSimple
import cn.dev33.satoken.router.SaRouter.notMatch
import cn.dev33.satoken.stp.StpUtil.*
import com.google.common.collect.ImmutableList.builder
import com.google.common.collect.ImmutableList.of
import org.github.common.props.CommonDynamicProperties
import org.github.core.spring.mvc.ReturnableValueHandlerKotlin
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodReturnValueHandler
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter
import javax.annotation.Resource


@Configuration
class WebMvcConfigWithSaToken: WebMvcConfigurer {
  @Resource
  private lateinit var commonDynamicProperties: CommonDynamicProperties

  override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
    registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/")
  }

  @Bean
  fun returnableValueHandler(adapter: RequestMappingHandlerAdapter) = ReturnableValueHandlerKotlin.apply {
    adapter.returnValueHandlers = builder<HandlerMethodReturnValueHandler>().add(this).addAll(adapter.returnValueHandlers ?: of()).build()
  }

  @Bean
  fun stpLogicJwt() = StpLogicJwtForSimple(TYPE).apply {
    setStpLogic(this)
  }

  override fun addInterceptors(registry: InterceptorRegistry) {
    registry.addInterceptor(SaInterceptor {notMatch(commonDynamicProperties.whiteList).check(SaFunction {checkLogin()})}).addPathPatterns("/**")
  }
}
