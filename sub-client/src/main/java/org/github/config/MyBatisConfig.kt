package org.github.config

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer
import com.baomidou.mybatisplus.core.injector.AbstractMethod
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
import org.github.mybatis.MyBatisMapper
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@MapperScan("org.github", annotationClass = MyBatisMapper::class)
@Configuration
class MyBatisConfig {
  @Bean
  fun mybatisPlusInterceptor() = MybatisPlusInterceptor().apply {
    addInnerInterceptor(PaginationInnerInterceptor())
    addInnerInterceptor(OptimisticLockerInnerInterceptor())
    // addInnerInterceptor(IllegalSQLInnerInterceptor())
    addInnerInterceptor(BlockAttackInnerInterceptor())
  }

  @Bean
  @Suppress("DEPRECATION")
  fun configurationCustomizer() = ConfigurationCustomizer {it.isUseDeprecatedExecutor = false}

  @Bean
  fun customSqlInjector() = CustomSqlInjector()
}

class CustomSqlInjector: DefaultSqlInjector() {
  override fun getMethodList(mapperClass: Class<*>): MutableList<AbstractMethod> = super.getMethodList(mapperClass).apply {add(InsertBatchSomeColumn())}
}
