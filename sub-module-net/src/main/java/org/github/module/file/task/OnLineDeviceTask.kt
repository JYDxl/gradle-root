package org.github.module.file.task

import io.netty.channel.Channel
import org.github.module.file.common.GlobalGroup
import org.github.netty.ops.info
import org.github.ops.info
import org.github.ops.log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class OnLineDeviceTask {
  @Autowired
  private lateinit var globalGroup: GlobalGroup

  @Scheduled(fixedRate = 1000 * 60)
  @Async
  fun showOnLineObj() {
    for (channel: Channel in globalGroup.iterator()) {
      log.info {"当前在线对象: ${channel.info}"}
    }
  }

  companion object {
    private val log = OnLineDeviceTask::class.log
  }
}
