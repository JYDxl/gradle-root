package org.github.shiro;

import lombok.val;
import org.apache.shiro.authc.AuthenticationToken;
import org.github.web.service.ICustomUserService;

import static org.github.spring.bootstrap.AppCtxHolder.getAppCtx;

public class WebAuthenFunc implements AuthenFunc {
    @Override
    public PartAuthenticationInfo apply(AuthenticationToken token) {
        val username = token.getPrincipal().toString();
        val userService = getAppCtx().getBean(ICustomUserService.class);
        val user = userService.queryUserInfo(username);
        return new PartAuthenticationInfo(user, user.getPassword(), user.getSalt());
    }
}
