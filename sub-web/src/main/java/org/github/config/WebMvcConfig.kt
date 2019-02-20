package org.github.config

import com.google.common.collect.ImmutableList.builder
import org.github.spring.mvc.ReturnableValueHandler
import org.github.spring.mvc.ReturnableValueHandlerKotlin
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodReturnValueHandler
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter

@Configuration
@EnableWebMvc
class WebMvcConfig: WebMvcConfigurer {
  override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
    registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/")
  }

  @Bean
  fun returnableValueHandler(adapter: RequestMappingHandlerAdapter) = ReturnableValueHandler().apply {
    adapter.returnValueHandlers = builder<HandlerMethodReturnValueHandler>().add(ReturnableValueHandlerKotlin).addAll(adapter.returnValueHandlers!!).build()
  }
}
