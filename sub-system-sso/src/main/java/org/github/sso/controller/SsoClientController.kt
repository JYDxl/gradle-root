package org.github.sso.controller

import cn.dev33.satoken.sso.SaSsoProcessor.instance
import cn.dev33.satoken.sso.SaSsoUtil.buildServerAuthUrl
import cn.dev33.satoken.stp.StpUtil.getTokenValue
import cn.dev33.satoken.stp.StpUtil.isLogin
import cn.dev33.satoken.stp.StpUtil.login
import org.github.core.DEVICE_TYPE_PC
import org.github.core.exception.ClientException
import org.github.core.spring.restful.json.JSONData
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SsoClientController {
  @RequestMapping("/sso/doLoginByTicket")
  fun doLoginByTicket(ticket: String): JSONData<String> {
    val loginId = instance.checkTicket(ticket, "/sso/doLoginByTicket") ?: throw ClientException("无效ticket：$ticket")
    login(loginId, DEVICE_TYPE_PC)
    val token = getTokenValue()!!
    return JSONData.of(token)
  }

  @RequestMapping("/sso/getSsoAuthUrl")
  fun getSsoAuthUrl(clientLoginUrl: String): JSONData<String> {
    val serverAuthUrl = buildServerAuthUrl(clientLoginUrl, "")!!
    return JSONData.of(serverAuthUrl)
  }

  @RequestMapping("/sso/hasLogin")
  fun hasLogin(): JSONData<Boolean> = JSONData.of(isLogin())

  @RequestMapping("/sso/*")
  fun ssoRequest(): Any = instance.clientDister()
}
