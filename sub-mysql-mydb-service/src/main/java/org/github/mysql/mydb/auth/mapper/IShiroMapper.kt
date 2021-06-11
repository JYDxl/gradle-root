package org.github.mysql.mydb.auth.mapper

import org.apache.ibatis.annotations.Param
import org.github.mybatis.MyBatisMapper
import org.github.mysql.mydb.model.auth.UserDTO
import org.github.shiro.AuthorInfo

@MyBatisMapper
interface IShiroMapper {
  fun queryAuthorInfo(@Param("userId") userId: Long): List<AuthorInfo>

  fun queryUserInfo(@Param("username") username: String): UserDTO?
}
