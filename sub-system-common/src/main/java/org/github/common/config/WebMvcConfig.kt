package org.github.common.config

import com.google.common.collect.ImmutableList.builder
import com.google.common.collect.ImmutableList.of
import org.github.core.spring.mvc.ReturnableValueHandlerKotlin
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodReturnValueHandler
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
}
