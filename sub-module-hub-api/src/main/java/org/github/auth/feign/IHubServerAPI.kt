package org.github.auth.feign

import org.github.auth.shiro.model.UserDTO
import org.github.spring.restful.json.JSONArrayReturn
import org.github.spring.restful.json.JSONDataReturn
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

//TODO
@FeignClient("hub-server")
interface IHubServerAPI {
  @GetMapping("/public/security/user/{username}")
  fun user(@PathVariable("username") username: String): JSONDataReturn<UserDTO>

  @GetMapping("/public/security/auth/{userId}")
  fun auth(@PathVariable("userId") userId: Long): JSONArrayReturn<Any>
}
