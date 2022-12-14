package org.github.sso.controller

import cn.dev33.satoken.sso.SaSsoProcessor.instance
import cn.dev33.satoken.sso.SaSsoUtil.buildServerAuthUrl
import cn.dev33.satoken.stp.StpUtil.getTokenValue
import cn.dev33.satoken.stp.StpUtil.isLogin
import cn.dev33.satoken.stp.StpUtil.login
import org.github.core.spring.restful.json.JSONDataReturn
import org.github.core.spring.restful.json.JSONReturn
import org.springframework.http.HttpStatus.UNAUTHORIZED
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SsoClientController {
    @RequestMapping("/sso/doLoginByTicket")
    fun doLoginByTicket(ticket: String): JSONReturn {
        val loginId = instance.checkTicket(ticket, "/sso/doLoginByTicket") ?: return JSONReturn.of(UNAUTHORIZED, "无效ticket：$ticket")
        login(loginId)
        val token = getTokenValue()!!
        return JSONDataReturn.of(token)
    }

    @RequestMapping("/sso/getSsoAuthUrl")
    fun getSsoAuthUrl(clientLoginUrl: String): JSONReturn {
        val serverAuthUrl = buildServerAuthUrl(clientLoginUrl, "")!!
        return JSONDataReturn.of(serverAuthUrl)
    }

    @RequestMapping("/sso/hasLogin")
    fun hasLogin(): JSONDataReturn<Boolean> = JSONDataReturn.of(isLogin())

    @RequestMapping("/sso/*")
    fun ssoRequest(): Any = instance.clientDister()
}
