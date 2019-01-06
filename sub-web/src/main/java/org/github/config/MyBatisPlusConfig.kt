package org.github.config

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.transaction.annotation.EnableTransactionManagement

@EnableTransactionManagement
@Configuration
@MapperScan("org.github.**.mapper")
class MyBatisPlusConfig {
  @Bean
  fun paginationInterceptor() = PaginationInterceptor()

  @Profile("dev", "test")
  @Bean
  fun performanceInterceptor() = PerformanceInterceptor().apply { isFormat = true }
}
