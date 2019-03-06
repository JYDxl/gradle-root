package org.github.config

import org.github.ops.log
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler
import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties
import org.springframework.boot.task.TaskExecutorBuilder
import org.springframework.boot.task.TaskExecutorCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.task.TaskDecorator
import org.springframework.core.task.TaskExecutor
import org.springframework.scheduling.annotation.AsyncConfigurer
import org.springframework.scheduling.annotation.EnableAsync

@Configuration
@EnableAsync
class AsyncConfig(private val props: TaskExecutionProperties, private val customizers: ObjectProvider<TaskExecutorCustomizer>, private val decorator: ObjectProvider<TaskDecorator>): AsyncConfigurer {
  /** pool. */
  private val pool = props.pool!!

  override fun getAsyncUncaughtExceptionHandler() = AsyncUncaughtExceptionHandler { ex, method, params ->
    log.error("Exception thrown by async method $method with arguments ${params.joinToString(prefix = "[", postfix = "]")}", ex)
  }

  override fun getAsyncExecutor() = applicationExecutor()

  @Bean
  fun applicationExecutor() = TaskExecutorBuilder()
    .queueCapacity(pool.queueCapacity)
    .corePoolSize(pool.coreSize)
    .maxPoolSize(pool.maxSize)
    .allowCoreThreadTimeOut(pool.isAllowCoreThreadTimeout)
    .keepAlive(pool.keepAlive)
    .threadNamePrefix(props.threadNamePrefix)
    .customizers(customizers)
    .taskDecorator(decorator.ifUnique)
    .build()!!

  companion object {
    /** log. */
    private val log = TaskExecutor::class.log
  }
}
