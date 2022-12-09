package org.github.web.controller;

import org.github.core.spring.restful.json.JSONDataReturn;
import org.github.core.spring.restful.json.JSONReturn;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static cn.dev33.satoken.sso.SaSsoProcessor.*;
import static cn.dev33.satoken.sso.SaSsoUtil.*;

@RestController
public class SsoClientController {
  @RequestMapping("/sso/getSsoAuthUrl")
  public JSONReturn getSsoAuthUrl(String clientLoginUrl) {
    String serverAuthUrl = buildServerAuthUrl(clientLoginUrl, "");
    return JSONDataReturn.of(serverAuthUrl);
  }

  @RequestMapping("/sso/*")
  public Object ssoRequest() {
    return instance.clientDister();
  }
}
