package org.github.common.config

import com.google.common.collect.ImmutableList.of
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered.HIGHEST_PRECEDENCE
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
class CorsConfig {
    @Bean
    fun ajaxCorsFilter(): FilterRegistrationBean<CorsFilter> {
        val config = CorsConfiguration().apply {
            allowCredentials = true
            allowedOriginPatterns = of("*")
            allowedMethods = of("*")
            allowedHeaders = of("*")
        }
        val source = UrlBasedCorsConfigurationSource().apply { registerCorsConfiguration("/**", config) }
        return FilterRegistrationBean(CorsFilter(source)).apply<FilterRegistrationBean<CorsFilter>> { order = HIGHEST_PRECEDENCE }
    }
}
