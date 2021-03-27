package org.github.config

import com.baomidou.mybatisplus.annotation.DbType.MYSQL
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MyBatisConfig {
  /** 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题(该属性会在旧插件移除后一同移除). */
  @Bean
  fun mybatisPlusInterceptor() = MybatisPlusInterceptor().apply {
    addInnerInterceptor(OptimisticLockerInnerInterceptor())
    addInnerInterceptor(PaginationInnerInterceptor(MYSQL))
    addInnerInterceptor(BlockAttackInnerInterceptor())
  }
}
