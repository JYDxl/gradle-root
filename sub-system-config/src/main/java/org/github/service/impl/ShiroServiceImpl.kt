package org.github.service.impl

import org.github.auth.feign.IServiceProviderHubServer
import org.github.service.IShiroService
import org.github.shiro.AuthorInfo
import org.github.shiro.User
import org.github.spring.restful.json.JSONArrayReturn
import org.github.spring.restful.json.JSONDataReturn
import org.github.spring.restful.ops.check
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShiroServiceImpl: IShiroService {
  @Autowired(required = false)
  private lateinit var hubServer: IServiceProviderHubServer

  override fun queryAuthorInfo(userId: Long): JSONArrayReturn<AuthorInfo> {
    return hubServer.auth(userId).check()
  }

  override fun queryUser(username: String): JSONDataReturn<out User> {
    return hubServer.user(username).check()
  }
}
