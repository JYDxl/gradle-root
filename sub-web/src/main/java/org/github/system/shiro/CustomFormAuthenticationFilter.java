package org.github.system.shiro;

import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import lombok.extern.slf4j.*;
import lombok.*;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import static com.google.common.collect.ImmutableMap.*;
import static java.util.Objects.*;
import static org.apache.shiro.web.util.WebUtils.*;

@Slf4j
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {
  private final String sessionIdCookieName;

  private final String failureUrl;

  private final String unauthorizedUrl;

  public CustomFormAuthenticationFilter(String sessionIdCookieName, String failureUrl, String unauthorizedUrl) {
    this.sessionIdCookieName = sessionIdCookieName;
    this.failureUrl = failureUrl;
    this.unauthorizedUrl = unauthorizedUrl;
  }

  @Override
  protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
    val sessionId = requireNonNull(subject.getSession(false)).getId();
    issueRedirect(request, response, getSuccessUrl(), of(sessionIdCookieName, sessionId));
    return false;
  }

  @Override
  protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
    log.debug(e.getMessage(), e);
    try {
      issueRedirect(request, response, failureUrl);
    } catch (IOException ioe) {
      log.error(ioe.getMessage(), ioe);
    }
    return false;
  }

  @Override
  protected void saveRequestAndRedirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
    issueRedirect(request, response, unauthorizedUrl);
  }
}
