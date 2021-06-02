package org.github.web.feign

import org.github.spring.restful.json.JSONReturn
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam

@FeignClient("web-server")
interface IServiceProviderWebServer {
  @GetMapping("/rest/json/basic")
  fun basic(
    @RequestParam("token") token: String?,
    @RequestHeader("Token") jwt: String?,
  ): JSONReturn
}
