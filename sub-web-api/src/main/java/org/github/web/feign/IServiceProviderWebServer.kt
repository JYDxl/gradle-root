package org.github.web.feign

import org.github.shiro.ShiroOps
import org.github.shiro.ShiroOps.JSESSIONID
import org.github.shiro.ShiroOps.JWT
import org.github.spring.restful.json.JSONReturn
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam

@FeignClient("web-server")
interface IServiceProviderWebServer: ShiroOps {
  @GetMapping("/rest/json/basic")
  fun basic(
    @RequestParam(JSESSIONID) jsessionid: String?,
    @RequestHeader(JWT) jwt: String?,
  ): JSONReturn
}
