package org.github.mysql.mydb.auth.service

import org.github.shiro.AuthorInfo
import org.github.shiro.User
import org.github.spring.restful.json.JSONArrayReturn
import org.github.spring.restful.json.JSONDataReturn

interface IShiroService {
  fun queryAuthorInfo(userId: String): JSONArrayReturn<AuthorInfo>

  fun queryUser(username: String): JSONDataReturn<out User>
}
