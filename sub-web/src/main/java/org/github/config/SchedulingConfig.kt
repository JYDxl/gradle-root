package org.github.config

import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.task.TaskSchedulingProperties
import org.springframework.boot.task.TaskSchedulerBuilder
import org.springframework.boot.task.TaskSchedulerCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.SchedulingConfigurer
import org.springframework.scheduling.config.ScheduledTaskRegistrar

@Configuration
class SchedulingConfig(private val props: TaskSchedulingProperties, private val customizers: ObjectProvider<TaskSchedulerCustomizer>): SchedulingConfigurer {
  override fun configureTasks(registrar: ScheduledTaskRegistrar) {
    registrar.setScheduler(applicationScheduler())
  }

  @Bean
  fun applicationScheduler() = TaskSchedulerBuilder()
    .poolSize(props.pool.size)
    .threadNamePrefix(props.threadNamePrefix)
    .customizers(customizers)
    .build()!!
}
