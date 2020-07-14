package org.github.config

import org.springframework.boot.task.TaskSchedulerBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.SchedulingConfigurer
import org.springframework.scheduling.config.ScheduledTaskRegistrar

@EnableScheduling
@Configuration
class SchedulingConfig(private val builder: TaskSchedulerBuilder): SchedulingConfigurer {
  override fun configureTasks(registrar: ScheduledTaskRegistrar) {
    registrar.setScheduler(taskScheduler())
  }

  @Bean
  fun taskScheduler() = builder.build()
}
