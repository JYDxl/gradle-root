package org.github.shiro;

import org.apache.shiro.web.filter.authc.LogoutFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CustomLogoutFilter extends LogoutFilter implements CustomFilterInvoker {
  @Override
  protected void issueRedirect(ServletRequest request, ServletResponse response, String redirectUrl) throws Exception {
    logoutSucceed(request, response);
  }
}