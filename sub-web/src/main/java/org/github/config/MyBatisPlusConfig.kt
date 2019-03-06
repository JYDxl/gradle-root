package org.github.config

import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor
import org.github.mybatis.MyBatisMapper
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.transaction.annotation.EnableTransactionManagement

@EnableTransactionManagement(proxyTargetClass = true)
@Configuration
@MapperScan("org.github", annotationClass = MyBatisMapper::class)
class MyBatisPlusConfig {
  @Bean
  fun paginationInterceptor() = PaginationInterceptor()

  @Profile("dev")
  @Bean
  fun performanceInterceptor() = PerformanceInterceptor()

  @Bean
  fun logicSqlInjector() = LogicSqlInjector()

  @Bean
  fun optimisticLockerInterceptor() = OptimisticLockerInterceptor()
}
