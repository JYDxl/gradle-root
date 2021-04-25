package org.github.system.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;

public class CustomLogoutFilter extends LogoutFilter {
  private final String logoutUrl;

  public CustomLogoutFilter(String logoutUrl) {
    this.logoutUrl = logoutUrl;
  }

  @Override
  protected String getRedirectUrl(ServletRequest request, ServletResponse response, Subject subject) {
    return logoutUrl;
  }
}
