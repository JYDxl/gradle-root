package org.github.service.impl

import org.github.auth.feign.IServiceProviderAuthServer
import org.github.exception.RemoteErrorException
import org.github.service.IShiroService
import org.github.shiro.AuthorInfo
import org.github.shiro.User
import org.github.spring.restful.json.JSONArrayReturn
import org.github.spring.restful.json.JSONDataReturn
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShiroServiceImpl: IShiroService {
  @Autowired(required = false)
  private lateinit var authServer: IServiceProviderAuthServer

  override fun queryAuthorInfo(userId: String): JSONArrayReturn<AuthorInfo> {
    val auth = authServer.auth(userId)
    if (auth.failure()) throw RemoteErrorException(auth)
    return auth
  }

  override fun queryUser(username: String): JSONDataReturn<out User> {
    val user = authServer.user(username)
    if (user.failure()) throw RemoteErrorException(user)
    return user
  }
}
