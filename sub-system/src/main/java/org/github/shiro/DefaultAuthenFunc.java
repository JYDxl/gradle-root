package org.github.shiro;

import lombok.NonNull;
import lombok.val;
import org.apache.shiro.authc.AuthenticationToken;
import org.github.mysql.mydb.auth.service.IShiroService;

import static java.util.Objects.requireNonNull;
import static org.github.spring.bootstrap.AppCtxHolder.getAppCtx;

public class DefaultAuthenFunc implements AuthenFunc {
  @Override
  public @NonNull PartAuthenticationInfo apply(@NonNull AuthenticationToken token) {
    val username    = token.getPrincipal().toString();
    val userService = getAppCtx().getBean(IShiroService.class);
    val data        = userService.queryUser(username);
    val user        = requireNonNull(data.getData());
    return new PartAuthenticationInfo(user, user.getPassword(), user.getSalt());
  }
}
