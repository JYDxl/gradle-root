package org.github.auth.shiro.service.impl

import org.apache.shiro.authc.AuthenticationException
import org.github.auth.shiro.mapper.IShiroMapper
import org.github.mysql.web.base.dict.Deleted.DELETED
import org.github.mysql.web.base.dict.Enabled.DISABLED
import org.github.service.IShiroService
import org.github.shiro.AuthorInfo
import org.github.shiro.User
import org.github.spring.restful.json.JSONArrayReturn
import org.github.spring.restful.json.JSONDataReturn
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service

@Primary
@Service
class AuthShiroServiceImpl: IShiroService {
  @Autowired
  private lateinit var shiroMapper: IShiroMapper

  override fun queryAuthorInfo(userId: String): JSONArrayReturn<AuthorInfo> {
    val list = shiroMapper.queryAuthorInfo(userId.toLong())
    return JSONArrayReturn.of(list)
  }

  override fun queryUser(username: String): JSONDataReturn<out User> {
    val user = shiroMapper.queryUserInfo(username) ?: throw AuthenticationException("用户未注册")
    if (DISABLED.code == user.status) throw AuthenticationException("该用户已禁用")
    if (DELETED.code == user.deleted) throw AuthenticationException("该用户已注销")
    return JSONDataReturn.of(user)
  }
}
