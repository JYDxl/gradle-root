package org.github.sso.sa;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import cn.dev33.satoken.interceptor.SaInterceptor;
import static cn.dev33.satoken.stp.StpUtil.*;

public class SaTokenConfigurer implements WebMvcConfigurer {
  // 注册拦截器
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 注册 Sa-Token 拦截器，校验规则为 StpUtil.checkLogin() 登录校验。
    registry
      .addInterceptor(new SaInterceptor(ignore -> checkLogin()))
      .addPathPatterns("/**")
      .excludePathPatterns("/index/**", "/static/**", "/sso/**", "/favicon.ico", "/error");
  }
}
