package org.github.auth.feign.fallback

import org.github.auth.feign.IHubServerAPI
import org.github.spring.restful.json.JSONDataReturn
import org.github.auth.shiro.model.UserDTO
import org.github.exception.SystemErrorException
import org.github.spring.restful.json.JSONArrayReturn
import org.github.shiro.AuthorInfo
import org.springframework.stereotype.Component

@Component
class HubServerAPIFallback: IHubServerAPI {
  override fun user(username: String): JSONDataReturn<UserDTO> {
    throw SystemErrorException("调用超时请稍后重试")
  }

  override fun auth(userId: Long): JSONArrayReturn<AuthorInfo> {
    throw SystemErrorException("调用超时请稍后重试")
  }
}
