package org.github.sso.feign

import org.github.TOKEN_NAME
import org.github.spring.restful.json.JSONArrayReturn
import org.github.sso.SERVER_SSO_NAME
import org.github.sso.bo.PermissionsBo
import org.github.sso.bo.RolesBo
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(SERVER_SSO_NAME)
interface ISsoServerAPI {
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
