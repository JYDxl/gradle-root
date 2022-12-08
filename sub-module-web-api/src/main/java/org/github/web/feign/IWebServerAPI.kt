package org.github.web.feign

import org.github.core.TOKEN_NAME
import org.github.core.spring.restful.json.JSONReturn
import org.github.web.SERVER_WEB_NAME
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(SERVER_WEB_NAME)
interface IWebServerAPI {
  //TODO
  @GetMapping("/rest/json/basic")
  fun basic(
    @RequestHeader(TOKEN_NAME) token: String?,
  ): JSONReturn
}
