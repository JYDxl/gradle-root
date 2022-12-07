package org.github.center.controller;

import org.github.center.bo.LoginBo;
import org.github.center.service.ICenterService;
import org.github.core.spring.restful.json.JSONReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.dev33.satoken.config.SaSsoConfig;
import cn.dev33.satoken.sso.SaSsoProcessor;

@RestController
public class SsoServerController {
  @Autowired
  private ICenterService centerService;

  @Autowired
  private void configSso(SaSsoConfig sso) {
// 配置：未登录时返回的View
    sso.setNotLoginView(() -> JSONReturn.auth(null));

    // 配置：登录处理函数
    sso.setDoLoginHandle((name, pwd) -> centerService.token(new LoginBo(name, pwd)));
  }

  @RequestMapping("/sso/*")
  public Object sso() {
    return SaSsoProcessor.instance.serverDister();
  }
}
