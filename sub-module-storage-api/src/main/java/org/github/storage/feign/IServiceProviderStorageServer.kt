package org.github.storage.feign

import org.github.shiro.ops.JSESSIONID
import org.github.shiro.ops.JWT
import org.github.spring.restful.json.JSONReturn
import org.github.storage.dto.DecreaseProductBO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.*

@FeignClient("storage-server")
@RequestMapping("/storage/")
interface IServiceProviderStorageServer {
  @PostMapping("decreaseProduct")
  fun decreaseProduct(
    @RequestParam(JSESSIONID) jsessionid: String?,
    @RequestHeader(JWT) jwt: String?,
    @RequestBody bo: DecreaseProductBO
  ): JSONReturn
}
