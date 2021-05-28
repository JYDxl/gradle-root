package org.github.shiro.controller

import org.github.service.ISystemService
import org.github.ops.log
import org.github.service.IShiroService
import org.github.shiro.JWTLogin
import org.github.spring.restful.Returnable
import org.github.spring.restful.json.JSONDataReturn
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class SystemController {
    private val log = SystemController::class.log

    @Autowired
    private lateinit var systemService: ISystemService

    @Autowired
    private lateinit var shiroService: IShiroService

    @GetMapping("/security/user/{username}")
    fun user(@PathVariable username: String): Returnable {
        val user = shiroService.queryUser(username)
        return JSONDataReturn.of(user)
    }

    @GetMapping("/security/auth/{userId}")
    fun auth(@PathVariable userId: String): Returnable {
        val auth = shiroService.queryAuthorInfo(userId)
        return JSONDataReturn.of(auth)
    }

    @PostMapping("/login")
    fun login(): Returnable {
        val user = systemService.login()
        return JSONDataReturn.of(user)
    }

    @RequestMapping("/token")
    fun token(): Returnable {
        val token = systemService.token()
        return JSONDataReturn.of(token)
    }

    @RequestMapping("/jwt")
    fun jwt(): Returnable {
        val jwt = systemService.jwt()
        return JSONDataReturn.of(jwt)
    }

    @PostMapping("/public/jwt")
    fun jwt(@RequestBody login: JWTLogin): Returnable {
        val jwt = systemService.jwt(login)
        return JSONDataReturn.of(jwt)
    }
}
