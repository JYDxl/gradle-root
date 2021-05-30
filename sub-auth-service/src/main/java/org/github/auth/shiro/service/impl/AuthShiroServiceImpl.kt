package org.github.auth.shiro.service.impl

import org.apache.shiro.authc.AuthenticationException
import org.springframework.context.annotation.Primary
import org.github.service.IShiroService
import org.springframework.beans.factory.annotation.Autowired
import org.github.auth.shiro.mapper.IShiroMapper
import org.github.shiro.AuthorInfo
import org.github.auth.shiro.model.UserDTO
import org.github.mysql.web.base.enums.Enable
import org.github.mysql.web.base.enums.Deleted
import org.springframework.stereotype.Service

@Primary
@Service
class AuthShiroServiceImpl : IShiroService {
    @Autowired
    private lateinit var shiroMapper: IShiroMapper

    override fun queryAuthorInfo(userId: String): List<AuthorInfo> {
        return shiroMapper.queryAuthorInfo(userId.toLong())
    }

    override fun queryUser(username: String): UserDTO {
        val user = shiroMapper.queryUserInfo(username) ?: throw AuthenticationException("用户未注册")
        if (Enable.disabled.code == user.status) throw AuthenticationException("该用户已禁用")
        if (Deleted.deleted.code == user.deleted) throw AuthenticationException("该用户已注销")
        return user
    }
}
