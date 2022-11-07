package org.github.web.sa

import cn.dev33.satoken.interceptor.SaInterceptor
import cn.dev33.satoken.stp.StpUtil.checkLogin
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


class SaTokenConfigurer: WebMvcConfigurer {
  override fun addInterceptors(registry: InterceptorRegistry) {
    registry
      .addInterceptor(SaInterceptor {checkLogin()})
      .addPathPatterns("/**")
      .excludePathPatterns("/index/login", "/index/register")
  }
}
