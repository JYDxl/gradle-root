package org.github.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authc.LogoutFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@Slf4j
public class CustomLogoutFilter extends LogoutFilter implements CustomFilterInvoker {
  @Override
  public boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
    if (isJWT(request) && !executeJWTLogin(request, response, log)) return false;
    return super.preHandle(request, response);
  }

  @Override
  protected void issueRedirect(ServletRequest request, ServletResponse response, String redirectUrl) throws Exception {
    logoutSucceed(request, response);
  }
}
