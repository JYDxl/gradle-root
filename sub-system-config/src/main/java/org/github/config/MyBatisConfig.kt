package org.github.config

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler
import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator
import com.baomidou.mybatisplus.core.injector.AbstractMethod
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
import org.apache.ibatis.reflection.MetaObject
import org.github.base.IEntity
import org.github.mybatis.MyBatisMapper
import org.github.shiro.ops.DEFAULT_VALUE_ANONYMOUS_ID
import org.github.shiro.ops.userOrNull
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
  fun customIdentifierGenerator(@Suppress("SpringJavaInjectionPointsAutowiringInspection") net: InetUtils) = CustomIdentifierGenerator(net.findFirstNonLoopbackAddress())
}

class CustomSqlInjector: DefaultSqlInjector() {
  override fun getMethodList(mapperClass: Class<*>): MutableList<AbstractMethod> = super.getMethodList(mapperClass).apply {add(InsertBatchSomeColumn())}
}

class CustomMetaObjectHandler: MetaObjectHandler {
  override fun insertFill(entity: MetaObject) {
    strictInsertFill(entity, "createTime", {now()}, LocalDateTime::class.java)
    strictInsertFill(entity, "creatorId", {id}, Long::class.java)
    strictInsertFill(entity, "modifyTime", {now()}, LocalDateTime::class.java)
    strictInsertFill(entity, "modifierId", {id}, Long::class.java)
  }

  override fun updateFill(entity: MetaObject) {
    strictUpdateFill(entity, "modifyTime", {now()}, LocalDateTime::class.java)
    strictUpdateFill(entity, "modifierId", {id}, Long::class.java)
  }

  private val id: Long get() = userOrNull?.id ?: DEFAULT_VALUE_ANONYMOUS_ID
}

class CustomIdentifierGenerator(addr: InetAddress): DefaultIdentifierGenerator(addr) {
  override fun nextId(entity: Any): Long {
    entity as IEntity
    return entity.pkVal() as Long? ?: super.nextId(entity)
  }

  override fun nextUUID(entity: Any): String {
    entity as IEntity
    return entity.pkVal() as String? ?: super.nextUUID(entity)
  }
}
