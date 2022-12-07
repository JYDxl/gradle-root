package org.github.web.feign

import org.github.core.spring.restful.json.JSONReturn
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam

@FeignClient("web-server")
interface IWebServerAPI {
  //TODO
  @GetMapping("/rest/json/basic")
  fun basic(
    @RequestParam("JSESSIONID") jsessionid: String?,
    @RequestHeader("JWT") jwt: String?,
  ): JSONReturn
}
