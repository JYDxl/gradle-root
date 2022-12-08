package org.github.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static cn.dev33.satoken.sso.SaSsoProcessor.*;

@RestController
public class SsoClientController {
  @RequestMapping("/sso/*")
  public Object ssoRequest() {
    return instance.clientDister();
  }
}
