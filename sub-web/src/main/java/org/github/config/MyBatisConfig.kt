package org.github.config

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
import org.github.mybatis.MyBatisMapper
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement

@MapperScan("org.github", annotationClass = MyBatisMapper::class)
@EnableTransactionManagement
@Configuration
class MyBatisConfig {
  @Bean
  fun paginationInterceptor() = PaginationInterceptor()

  @Bean
  fun optimisticLockerInterceptor() = OptimisticLockerInterceptor()
}
