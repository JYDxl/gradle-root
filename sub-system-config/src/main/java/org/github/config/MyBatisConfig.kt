package org.github.config

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler
import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator
import com.baomidou.mybatisplus.core.injector.AbstractMethod
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector
import com.baomidou.mybatisplus.core.metadata.TableInfo
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
import org.apache.ibatis.reflection.MetaObject
import org.github.base.IEntity
import org.github.mybatis.MyBatisMapper
import org.mybatis.spring.annotation.MapperScan
import org.springframework.cloud.commons.util.InetUtils
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.net.InetAddress
import java.time.LocalDateTime
import java.time.LocalDateTime.now

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
  fun customSqlInjector() = CustomSqlInjector()

  @Bean
  fun customMetaObjectHandler() = CustomMetaObjectHandler()

  @Bean
  fun customIdentifierGenerator(inetUtils: InetUtils) = CustomIdentifierGenerator(inetUtils.findFirstNonLoopbackAddress())
}

class CustomSqlInjector: DefaultSqlInjector() {
  override fun getMethodList(mapperClass: Class<*>, tableInfo: TableInfo): MutableList<AbstractMethod> = super.getMethodList(mapperClass, tableInfo).apply {add(InsertBatchSomeColumn())}
}

class CustomMetaObjectHandler: MetaObjectHandler {
  override fun insertFill(entity: MetaObject) {
    strictInsertFill(entity, "creatorName", {name}, String::class.java)
    strictInsertFill(entity, "createdTime", {now()}, LocalDateTime::class.java)
    strictInsertFill(entity, "updaterName", {name}, String::class.java)
    strictInsertFill(entity, "updatedTime", {now()}, LocalDateTime::class.java)
  }

  override fun updateFill(entity: MetaObject) {
    strictUpdateFill(entity, "updaterName", {name}, String::class.java)
    strictUpdateFill(entity, "updatedTime", {now()}, LocalDateTime::class.java)
  }

  private val name: String get() = ""
}

class CustomIdentifierGenerator(addr: InetAddress): DefaultIdentifierGenerator(addr) {
  override fun nextId(entity: Any): Long {
    if (entity is IEntity) return entity.pkVal() as Long? ?: super.nextId(entity)
    return super.nextId(entity)
  }

  override fun nextUUID(entity: Any): String {
    if (entity is IEntity) return entity.pkVal() as String? ?: super.nextUUID(entity)
    return super.nextUUID(entity)
  }
}
