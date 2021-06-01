package org.github.auth.feign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.github.spring.restful.json.JSONDataReturn
import org.github.auth.shiro.model.UserDTO
import org.github.constant.Constants.SERVICE_PROVIDER_AUTH_SERVER
import org.github.shiro.AuthorInfo
import org.github.spring.restful.json.JSONArrayReturn

@FeignClient(SERVICE_PROVIDER_AUTH_SERVER)
interface IServiceProviderAuthServer {
  @GetMapping("/public/security/user/{username}")
  fun user(@PathVariable("username") username: String): JSONDataReturn<UserDTO>

  @GetMapping("/public/security/auth/{userId}")
  fun auth(@PathVariable("userId") userId: String): JSONArrayReturn<AuthorInfo>
}
