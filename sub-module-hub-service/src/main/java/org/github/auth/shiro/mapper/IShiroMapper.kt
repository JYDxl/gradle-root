package org.github.auth.shiro.mapper

import org.github.mybatis.MyBatisMapper
import org.github.shiro.AuthorInfo
import org.github.auth.shiro.model.UserDTO

@MyBatisMapper
interface IShiroMapper {
  fun queryAuthorInfo(userId: Long): MutableList<AuthorInfo>

  fun queryUserInfo(username: String): UserDTO?
}
