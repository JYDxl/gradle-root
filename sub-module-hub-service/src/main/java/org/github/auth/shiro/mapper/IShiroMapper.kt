package org.github.auth.shiro.mapper

import org.apache.ibatis.annotations.Param
import org.github.mybatis.MyBatisMapper
import org.github.shiro.AuthorInfo
import org.github.auth.shiro.model.UserDTO

@MyBatisMapper
interface IShiroMapper {
  fun queryAuthorInfo(@Param("userId") userId: Long): List<AuthorInfo>

  fun queryUserInfo(@Param("username") username: String): UserDTO?
}
