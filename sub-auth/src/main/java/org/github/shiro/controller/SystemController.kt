package org.github.shiro.controller

import org.github.service.ISystemService
import org.github.ops.log
import org.github.service.IShiroService
import org.github.shiro.JWTLogin
import org.github.spring.restful.Returnable
import org.github.spring.restful.json.JSONDataReturn
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RequestMapping("/")
@Controller
class SystemController {
    private val log = SystemController::class.log

    @Autowired
    private lateinit var systemService: ISystemService

    @Autowired
    private lateinit var shiroService: IShiroService

    @GetMapping("security/user/{username}")
    fun user(@PathVariable username: String): Returnable = JSONDataReturn.of(shiroService.queryUser(username))

    @GetMapping("security/auth/{userId}")
    fun auth(@PathVariable userId: String): Returnable = JSONDataReturn.of(shiroService.queryAuthorInfo(userId))

    @PostMapping("login")
    fun login(): Returnable = JSONDataReturn.of(systemService.login())

    @RequestMapping("token")
    fun token(): Returnable = JSONDataReturn.of(systemService.token())

    @RequestMapping("jwt")
    fun jwt(): Returnable = JSONDataReturn.of(systemService.jwt())

    @PostMapping("public/jwt")
    fun jwt(@RequestBody login: JWTLogin): Returnable = JSONDataReturn.of(systemService.jwt(login))
}
