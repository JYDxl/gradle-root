package org.github.leadnews.behavior.controller.v1

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.github.leadnews.behavior.dto.SaveBehaviorBO
import org.github.leadnews.behavior.service.IBehaviorService
import org.github.ops.trim
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@Api(tags = ["用户行为管理"])
@RequestMapping("/api/v1/behavior/")
@RestController
class BehaviorController {
  @Autowired
  private lateinit var behaviorService: IBehaviorService

  @ApiOperation("保存用户行为信息")
  @PostMapping("save_behavior")
  fun saveBehavior(@RequestBody @Valid bo: SaveBehaviorBO) = behaviorService.saveBehavior(bo.trim())
}
