package org.github.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@Slf4j
public class CustomSSOAuthenticationFilter extends CustomAuthenticationFilter {
  public CustomSSOAuthenticationFilter(boolean simple) {
    super(simple);
  }

  @Override
  public void onWEBLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
    super.onWEBLoginSuccess(token, subject, request, response);
    sessionKickOut(subject);
  }
}
