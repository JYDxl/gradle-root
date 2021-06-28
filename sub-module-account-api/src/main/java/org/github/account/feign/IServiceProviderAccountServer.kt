package org.github.account.feign

import org.github.account.dto.DecreaseAccountBO
import org.github.shiro.ops.JSESSIONID
import org.github.shiro.ops.JWT
import org.github.spring.restful.json.JSONReturn
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.*

@FeignClient("account-server")
@RequestMapping("/account/")
interface IServiceProviderAccountServer {
  @PostMapping("decreaseMoney")
  fun decreaseMoney(
    @RequestParam(JSESSIONID) jsessionid: String?,
    @RequestHeader(JWT) jwt: String?,
    @RequestBody bo: DecreaseAccountBO
  ): JSONReturn
}
