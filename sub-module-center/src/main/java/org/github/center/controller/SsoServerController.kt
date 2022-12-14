package org.github.center.controller;

import cn.dev33.satoken.config.SaSsoConfig;
import javax.annotation.Resource;
import org.github.center.bo.LoginBo;
import org.github.center.service.ICenterService;
import org.github.core.spring.restful.json.JSONDataReturn;
import org.github.core.spring.restful.json.JSONReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static cn.dev33.satoken.sso.SaSsoConsts.MODE_SIMPLE;
import static cn.dev33.satoken.sso.SaSsoProcessor.instance;
import static cn.dev33.satoken.sso.SaSsoUtil.buildRedirectUrl;
import static cn.dev33.satoken.sso.SaSsoUtil.checkRedirectUrl;
import static cn.dev33.satoken.stp.StpUtil.getLoginId;
import static cn.dev33.satoken.stp.StpUtil.isLogin;
import static cn.dev33.satoken.util.SaFoxUtil.decoderUrl;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestController
public class SsoServerController {
  @Resource
  private ICenterService centerService;

  @Autowired
  private void configSso(SaSsoConfig sso) {
    // 配置：未登录时返回的View
    sso.setNotLoginView(() -> JSONReturn.of(UNAUTHORIZED, null));
    // 配置：登录处理函数
    sso.setDoLoginHandle((name, pwd) -> centerService.login(new LoginBo(name, pwd)));
  }

  @RequestMapping("/sso/getRedirectUrl")
  private JSONReturn getRedirectUrl(String redirect, String mode) {
    // 未登录
    if (!isLogin()) return JSONReturn.of(UNAUTHORIZED, null);
    // 已登录
    if (MODE_SIMPLE.equals(mode)) {
      // 模式一
      checkRedirectUrl(decoderUrl(redirect));
      return JSONDataReturn.of(redirect);
    } else {
      // 模式二或模式三
      String redirectUrl = buildRedirectUrl(getLoginId(), redirect);
      return JSONDataReturn.of(redirectUrl);
    }
  }

  @RequestMapping("/sso/*")
  public Object sso() {
    return instance.serverDister();
  }
}