package org.github.mysql.mydb.auth.service.impl

import org.apache.shiro.authc.AuthenticationException
import org.github.mysql.mydb.auth.mapper.IShiroMapper
import org.github.mysql.mydb.auth.service.IShiroService
import org.github.mysql.mydb.base.dict.Deleted.DELETED
import org.github.mysql.mydb.base.dict.Enabled.DISABLED
import org.github.shiro.AuthorInfo
import org.github.shiro.User
import org.github.spring.restful.json.JSONArrayReturn
import org.github.spring.restful.json.JSONDataReturn
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service

@Primary
@Service
class ShiroServiceImpl: IShiroService {
  @Autowired
  private lateinit var shiroMapper: IShiroMapper

  override fun queryAuthorInfo(userId: String): JSONArrayReturn<AuthorInfo> {
    val list = shiroMapper.queryAuthorInfo(userId.toLong())
    return JSONArrayReturn.of(list)
  }

  override fun queryUser(username: String): JSONDataReturn<out User> {
    val user = shiroMapper.queryUserInfo(username) ?: throw AuthenticationException("用户未注册")
    if (DISABLED.code == user.enabled) throw AuthenticationException("该用户已禁用")
    if (DELETED.code == user.deleted) throw AuthenticationException("该用户已注销")
    return JSONDataReturn.of(user)
  }
}
