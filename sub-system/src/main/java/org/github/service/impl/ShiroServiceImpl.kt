package org.github.service.impl

import org.github.service.IShiroService
import org.springframework.beans.factory.annotation.Autowired
import org.github.auth.feign.IServiceProviderAuthServer
import org.github.service.ISystemService
import org.github.shiro.AuthorInfo
import org.github.shiro.User
import java.util.*

class ShiroServiceImpl : IShiroService {
    @Autowired(required = false)
    private lateinit var authServer: IServiceProviderAuthServer

    @Autowired
    private lateinit var systemService: ISystemService

    override fun queryAuthorInfo(userId: String): List<AuthorInfo> {
        val (token, jwt) = systemService.feign()
        //TODO 异常处理等
        return Objects.requireNonNull(authServer.auth(token, jwt, userId).data)
    }

    override fun queryUser(username: String): User {
        val (token, jwt) = systemService.feign()
        //TODO 异常处理等
        return Objects.requireNonNull(authServer.user(token, jwt, username).data)!!
    }
}