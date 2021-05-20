package org.github.config

import org.github.ops.log
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler
import org.springframework.boot.task.TaskExecutorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.AsyncConfigurer
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

@Configuration
@EnableAsync
class AsyncConfig(private val builder: TaskExecutorBuilder): AsyncConfigurer {
  /** log. */
  private val log = AsyncUncaughtExceptionHandler::class.log

  override fun getAsyncUncaughtExceptionHandler() = AsyncUncaughtExceptionHandler { ex, method, params ->
    log.error("Exception thrown by async method $method with arguments ${params.joinToString(prefix = "[", postfix = "]")}", ex)
  }

  override fun getAsyncExecutor(): ThreadPoolTaskExecutor = taskExecutor()

  @Bean
  fun taskExecutor(): ThreadPoolTaskExecutor = builder.build()
}
