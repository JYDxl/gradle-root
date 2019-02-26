package org.github.config

import com.google.common.eventbus.AsyncEventBus
import org.github.event.EventSubscriber
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.task.TaskExecutor

@Configuration
class EventBusConfig {
  @Bean
  fun eventBus(@Qualifier("taskExecutor") executor: TaskExecutor, subscribers: List<EventSubscriber>) = AsyncEventBus(executor).apply { subscribers.forEach { register(it) } }
}
