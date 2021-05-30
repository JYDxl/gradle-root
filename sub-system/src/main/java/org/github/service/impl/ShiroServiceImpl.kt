package org.github.service.impl

import org.github.auth.feign.IServiceProviderAuthServer
import org.github.service.IShiroService
import org.github.service.ISystemService
import org.github.shiro.AuthorInfo
import org.github.shiro.User
import org.github.spring.restful.json.JSONArrayReturn
import org.github.spring.restful.json.JSONDataReturn
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShiroServiceImpl : IShiroService {
    @Autowired(required = false)
    private lateinit var authServer: IServiceProviderAuthServer

    @Autowired
    private lateinit var systemService: ISystemService

    override fun queryAuthorInfo(userId: String): JSONArrayReturn<AuthorInfo> {
        val (token, jwt) = systemService.feign()
        return authServer.auth(token, jwt, userId)
    }

    override fun queryUser(username: String): JSONDataReturn<out User> {
        val (token, jwt) = systemService.feign()
        return authServer.user(token, jwt, username)
    }
}
