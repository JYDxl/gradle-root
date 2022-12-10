package org.github.web.controller;

import org.github.core.spring.restful.json.JSONDataReturn;
import org.github.core.spring.restful.json.JSONReturn;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static cn.dev33.satoken.sso.SaSsoProcessor.instance;
import static cn.dev33.satoken.sso.SaSsoUtil.buildServerAuthUrl;
import static cn.dev33.satoken.stp.StpUtil.getTokenValue;
import static cn.dev33.satoken.stp.StpUtil.isLogin;
import static cn.dev33.satoken.stp.StpUtil.login;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestController
public class SsoClientController {
  @RequestMapping("/sso/doLoginByTicket")
  public JSONReturn doLoginByTicket(String ticket) {
    Object loginId = instance.checkTicket(ticket, "/sso/doLoginByTicket");
    if (loginId == null) return JSONReturn.of(UNAUTHORIZED, "无效ticket：" + ticket);
    login(loginId);
    String token = getTokenValue();
    return JSONDataReturn.of(token);
  }

  @RequestMapping("/sso/getSsoAuthUrl")
  public JSONReturn getSsoAuthUrl(String clientLoginUrl) {
    String serverAuthUrl = buildServerAuthUrl(clientLoginUrl, "");
    return JSONDataReturn.of(serverAuthUrl);
  }

  @RequestMapping("/sso/hasLogin")
  public Object hasLogin() {
    boolean flag = isLogin();
    return JSONDataReturn.of(flag);
  }

  @RequestMapping("/sso/*")
  public Object ssoRequest() {
    return instance.clientDister();
  }
}
