package org.github.center.feign

import org.github.core.TOKEN_NAME
import org.github.center.SERVER_CENTER_NAME
import org.github.center.bo.PermissionsBo
import org.github.center.bo.RolesBo
import org.github.core.spring.restful.json.JSONArrayReturn
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(SERVER_CENTER_NAME)
interface ICenterServerAPI {
  @PostMapping("/rest/json/basic")
  fun getPermissionList(
      @RequestHeader(TOKEN_NAME) token: String?,
      @RequestBody bo: PermissionsBo,
  ): JSONArrayReturn<String>

  @PostMapping("/rest/json/basic")
  fun getRoleList(
      @RequestHeader(TOKEN_NAME) token: String?,
      @RequestBody bo: RolesBo,
  ): JSONArrayReturn<String>
}
