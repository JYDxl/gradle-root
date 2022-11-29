package org.github.config

import cn.dev33.satoken.interceptor.SaInterceptor
import cn.dev33.satoken.stp.StpUtil.checkLogin
import com.google.common.collect.ImmutableList.builder
import com.google.common.collect.ImmutableList.of
import org.github.spring.mvc.ReturnableValueHandlerKotlin
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodReturnValueHandler
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter

@Configuration
class WebMvcConfig: WebMvcConfigurer {
  override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
    registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/")
  }

  @Bean
  fun returnableValueHandler(adapter: RequestMappingHandlerAdapter) = ReturnableValueHandlerKotlin.apply {
    adapter.returnValueHandlers = builder<HandlerMethodReturnValueHandler>().add(this).addAll(adapter.returnValueHandlers ?: of()).build()
  }

  override fun addInterceptors(registry: InterceptorRegistry) {
    registry
      .addInterceptor(SaInterceptor {checkLogin()})
      .addPathPatterns("/**")
      .excludePathPatterns("/index/**", "/static/**", "/sso/**", "/main", "/role/**", "/error", "/public/**", "/")
  }
}
