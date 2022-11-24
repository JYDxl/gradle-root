package org.github.sso.feign

import org.github.TOKEN_NAME
import org.github.spring.restful.json.JSONReturn
import org.github.sso.SERVER_SSO_NAME
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(SERVER_SSO_NAME)
interface ISsoServerAPI {
  @GetMapping("/rest/json/basic")
  fun basic(
    @RequestHeader(TOKEN_NAME) token: String?,
  ): JSONReturn
}
