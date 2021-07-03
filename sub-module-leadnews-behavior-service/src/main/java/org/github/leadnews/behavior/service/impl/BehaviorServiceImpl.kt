package org.github.leadnews.behavior.service.impl

import org.github.leadnews.behavior.dto.SaveBehaviorBO
import org.github.leadnews.behavior.service.IBehaviorService
import org.github.shiro.ops.userOrNull
import org.github.spring.restful.json.JSONReturn
import org.springframework.stereotype.Service

@Service
class BehaviorServiceImpl: IBehaviorService {
  override fun saveBehavior(bo: SaveBehaviorBO): JSONReturn {
    userOrNull?.apply {bo.entryId = id}
    TODO()
  }
}
