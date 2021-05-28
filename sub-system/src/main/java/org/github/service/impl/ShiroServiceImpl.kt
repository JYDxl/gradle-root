package org.github.service.impl

import org.github.auth.feign.IServiceProviderAuthServer
import org.github.exception.RemoteErrorException
import org.github.service.IShiroService
import org.github.service.ISystemService
import org.github.shiro.AuthorInfo
import org.github.shiro.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShiroServiceImpl: IShiroService {
  @Autowired(required = false)
  private lateinit var authServer: IServiceProviderAuthServer

  @Autowired
  private lateinit var systemService: ISystemService

  override fun queryAuthorInfo(userId: String): List<AuthorInfo> {
    val (token, jwt) = systemService.feign()
    val res = authServer.auth(token, jwt, userId)
    if (res.failure()) throw RemoteErrorException(res)
    return requireNotNull(res.data)
  }

  override fun queryUser(username: String): User {
    val (token, jwt) = systemService.feign()
    val res = authServer.user(token, jwt, username)
    if (res.failure()) throw RemoteErrorException(res)
    return requireNotNull(res.data)
  }
}
