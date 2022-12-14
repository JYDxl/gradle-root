package org.github.common.config;

import lombok.val;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import static com.google.common.collect.ImmutableList.of;
import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@Configuration
public class CorsConfig {
  @Bean
  public FilterRegistrationBean<CorsFilter> ajaxCorsFilter() {
    val config = new CorsConfiguration();
    config.setAllowCredentials(true);
    config.setAllowedOriginPatterns(of("*"));
    config.setAllowedMethods(of("*"));
    config.setAllowedHeaders(of("*"));
    val source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", config);
    val bean = new FilterRegistrationBean<>(new CorsFilter(source));
    bean.setOrder(HIGHEST_PRECEDENCE);
    return bean;
  }
}
