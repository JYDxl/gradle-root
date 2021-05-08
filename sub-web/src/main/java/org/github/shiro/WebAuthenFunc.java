package org.github.shiro;

import lombok.*;
import org.github.web.system.IShiroService;
import org.apache.shiro.authc.AuthenticationToken;
import static org.github.spring.bootstrap.AppCtxHolder.*;

public class WebAuthenFunc implements AuthenFunc {
  @Override
  public PartAuthenticationInfo apply(AuthenticationToken token) {
    val username    = token.getPrincipal().toString();
    val userService = getAppCtx().getBean(IShiroService.class);
    val user        = userService.queryUser(username);
    return new PartAuthenticationInfo(user, user.getPassword(), user.getSalt());
  }
}
