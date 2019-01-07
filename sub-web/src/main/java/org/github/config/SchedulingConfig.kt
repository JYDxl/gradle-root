package org.github.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.SchedulingConfigurer
import org.springframework.scheduling.config.ScheduledTaskRegistrar
import java.util.concurrent.Executors

@EnableScheduling
@Configuration
class SchedulingConfig : SchedulingConfigurer {
  override fun configureTasks(taskRegistrar: ScheduledTaskRegistrar) {
    taskRegistrar.setScheduler(taskScheduler())
  }

  @Bean
  fun taskScheduler() = Executors.newScheduledThreadPool(100)!!
}
