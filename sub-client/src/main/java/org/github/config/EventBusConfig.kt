package org.github.config

import com.google.common.eventbus.AsyncEventBus
import com.google.common.util.concurrent.ListeningExecutorService
import com.google.common.util.concurrent.ListeningScheduledExecutorService
import com.google.common.util.concurrent.MoreExecutors.listeningDecorator
import org.github.event.EventSubscriber
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.task.TaskExecutor
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler

@Configuration
class EventBusConfig {
  @Bean
  fun guavaEventBus(@Qualifier("taskExecutor") taskExecutor: TaskExecutor, subscribers: List<EventSubscriber>) = AsyncEventBus(taskExecutor).apply {subscribers.forEach {register(it)}}

  @Bean
  fun listeningExecutor(@Qualifier("taskExecutor") executor: ThreadPoolTaskExecutor): ListeningExecutorService = listeningDecorator(executor.threadPoolExecutor)

  @Bean
  fun listeningScheduler(@Qualifier("taskScheduler") scheduler: ThreadPoolTaskScheduler): ListeningScheduledExecutorService = listeningDecorator(scheduler.scheduledExecutor)
}
