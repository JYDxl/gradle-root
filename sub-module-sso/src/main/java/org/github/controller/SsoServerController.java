package org.github.controller;

import org.github.spring.restful.json.JSONReturn;
import org.github.sso.bo.LoginBo;
import org.github.sso.service.ISsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.dev33.satoken.config.SaSsoConfig;
import cn.dev33.satoken.sso.SaSsoProcessor;

@RestController
public class SsoServerController {
  @Autowired
  private ISsoService ssoService;

  @Autowired
  private void configSso(SaSsoConfig sso) {
// 配置：未登录时返回的View
    sso.setNotLoginView(() -> JSONReturn.auth(null));

    // 配置：登录处理函数
    sso.setDoLoginHandle((name, pwd) -> ssoService.token(new LoginBo(name, pwd)));
  }

  @RequestMapping("/sso/*")
  public Object sso() {
    return SaSsoProcessor.instance.serverDister();
  }
}
