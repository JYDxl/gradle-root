package org.github.service

import org.github.shiro.JWTLogin
import org.github.shiro.User
import org.github.spring.restful.json.JSONDataReturn

interface ISystemService {
    fun login(): JSONDataReturn<User>

    fun token(): JSONDataReturn<String?>

    fun jwt(): JSONDataReturn<String>

    fun jwt(login: JWTLogin): JSONDataReturn<String>
}
