package org.github.center.controller

import cn.dev33.satoken.config.SaSsoConfig
import cn.dev33.satoken.sso.SaSsoConsts.MODE_SIMPLE
import cn.dev33.satoken.sso.SaSsoProcessor.instance
import cn.dev33.satoken.sso.SaSsoUtil.buildRedirectUrl
import cn.dev33.satoken.sso.SaSsoUtil.checkRedirectUrl
import cn.dev33.satoken.stp.StpUtil.getLoginId
import cn.dev33.satoken.stp.StpUtil.isLogin
import cn.dev33.satoken.util.SaFoxUtil.decoderUrl
import org.github.center.bo.LoginBo
import org.github.center.service.ICenterService
import org.github.core.spring.ops.appCtx
import org.github.core.spring.ops.objectMapper
import org.github.core.spring.ops.req
import org.github.core.spring.restful.json.JSONDataReturn
import org.github.core.spring.restful.json.JSONReturn
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus.UNAUTHORIZED
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SsoServerController {
  @Autowired
  private fun configSso(sso: SaSsoConfig) {
    // 配置：未登录时返回的View
    sso.setNotLoginView {JSONReturn.of(UNAUTHORIZED, null)}
    // 配置：登录处理函数
    sso.setDoLoginHandle {_: String?, _: String? -> appCtx.getBean(ICenterService::class.java).login(objectMapper.readValue(req!!.inputStream, LoginBo::class.java))}
  }

  @RequestMapping("/sso/getRedirectUrl")
  private fun getRedirectUrl(redirect: String, mode: String): JSONReturn {
    // 未登录
    if (!isLogin()) return JSONReturn.of(UNAUTHORIZED, null)
    // 已登录
    return if (MODE_SIMPLE == mode) {
      // 模式一
      checkRedirectUrl(decoderUrl(redirect))
      JSONDataReturn.of(redirect)
    } else {
      // 模式二或模式三
      val redirectUrl = buildRedirectUrl(getLoginId(), redirect)!!
      JSONDataReturn.of(redirectUrl)
    }
  }

  @RequestMapping("/sso/*")
  fun sso(): Any = instance.serverDister()
}
