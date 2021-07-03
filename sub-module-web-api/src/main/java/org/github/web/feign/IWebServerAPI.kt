package org.github.web.feign

import org.github.shiro.ops.JSESSIONID
import org.github.shiro.ops.JWT
import org.github.spring.restful.json.JSONReturn
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam

@FeignClient("web-server")
interface IWebServerAPI {
  @GetMapping("/rest/json/basic")
  fun basic(
    @RequestParam(JSESSIONID) jsessionid: String?,
    @RequestHeader(JWT) jwt: String?,
  ): JSONReturn
}
