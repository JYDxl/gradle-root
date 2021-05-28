package org.github.service

import org.github.shiro.AuthorInfo
import org.github.shiro.User

interface IShiroService {
    fun queryAuthorInfo(userId: String): List<AuthorInfo>

    fun queryUser(username: String): User
}
