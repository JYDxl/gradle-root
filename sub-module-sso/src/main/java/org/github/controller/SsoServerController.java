package org.github.controller;

import org.github.sso.bo.LoginBo;
import org.github.sso.service.ISsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.dev33.satoken.config.SaSsoConfig;
import static cn.dev33.satoken.sso.SaSsoProcessor.*;

@RestController
public class SsoServerController {
  @Autowired
  private ISsoService ssoService;

  @Autowired
  private void configSso(SaSsoConfig sso) {
    // 配置：未登录时返回的View
    sso.setNotLoginView(() -> "当前会话在SSO-Server端尚未登录，请先访问"
      + "<a href='/sso/doLogin?name=JYD_XL&pwd=XLrootJYD713' target='_blank'> doLogin登录 </a>"
      + "进行登录之后，刷新页面开始授权");

    // 配置：登录处理函数
    sso.setDoLoginHandle((username, password) -> ssoService.login(new LoginBo(username, password)));
  }

  @RequestMapping("/sso/*")
  public Object sso() {
    return instance.serverDister();
  }
}