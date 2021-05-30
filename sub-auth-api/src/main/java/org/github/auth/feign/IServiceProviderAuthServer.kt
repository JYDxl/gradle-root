package org.github.auth.feign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.PathVariable
import org.github.spring.restful.json.JSONDataReturn
import org.github.auth.shiro.model.UserDTO
import org.github.constant.Constants.SERVICE_PROVIDER_AUTH_SERVER
import org.github.shiro.AuthorInfo
import org.github.spring.restful.json.JSONArrayReturn

@FeignClient(SERVICE_PROVIDER_AUTH_SERVER)
interface IServiceProviderAuthServer {
  @GetMapping("/security/user/{username}")
  fun user(
    @RequestParam("token") token: String?,
    @RequestHeader("Token") jwt: String?,
    @PathVariable("username") username: String
  ): JSONDataReturn<UserDTO>

  @GetMapping("/security/auth/{userId}")
  fun auth(
    @RequestParam("token") token: String?,
    @RequestHeader("Token") jwt: String?,
    @PathVariable("userId") userId: String
  ): JSONArrayReturn<AuthorInfo>
}
