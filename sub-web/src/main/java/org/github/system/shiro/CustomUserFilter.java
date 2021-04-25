package org.github.system.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.web.filter.authc.UserFilter;
import static org.apache.shiro.web.util.WebUtils.*;

public class CustomUserFilter extends UserFilter {
  private final String unauthorizedUrl;

  public CustomUserFilter(String unauthorizedUrl) {
    this.unauthorizedUrl = unauthorizedUrl;
  }

  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
    issueRedirect(request, response, unauthorizedUrl);
    return false;
  }
}
