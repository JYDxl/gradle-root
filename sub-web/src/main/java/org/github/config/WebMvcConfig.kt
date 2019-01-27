package org.github.config

import org.github.spring.mvc.ReturnableValueHandler
import org.github.spring.mvc.ReturnableValueHandlerKotlin
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodReturnValueHandler
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@EnableWebMvc
class WebMvcConfig : WebMvcConfigurer {
  override fun addReturnValueHandlers(handlers: MutableList<HandlerMethodReturnValueHandler>) {
    handlers += returnableValueHandlerKotlin()
    handlers += returnableValueHandler()
  }

  @Bean
  fun returnableValueHandlerKotlin() = ReturnableValueHandlerKotlin()

  @Bean
  fun returnableValueHandler() = ReturnableValueHandler()
}
