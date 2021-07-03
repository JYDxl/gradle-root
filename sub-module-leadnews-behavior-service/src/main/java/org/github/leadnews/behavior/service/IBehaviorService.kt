package org.github.leadnews.behavior.service

import org.github.leadnews.behavior.dto.SaveBehaviorBO
import org.github.spring.restful.json.JSONReturn

interface IBehaviorService {
  fun saveBehavior(bo: SaveBehaviorBO): JSONReturn
}
