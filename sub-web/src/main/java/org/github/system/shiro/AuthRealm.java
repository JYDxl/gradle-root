package org.github.system.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;

public class AuthRealm extends AbstractRealm {
  public AuthRealm(CredentialsMatcher matcher) {
    super(matcher);
    setAuthenticationCacheName("authen:web");
    setAuthorizationCacheName("author");
  }

  @Override protected void assertCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) throws AuthenticationException {
    if (!getCredentialsMatcher().doCredentialsMatch(token, info)) throw new IncorrectCredentialsException("用户名或密码错误");
  }

  @Override
  protected String getUsername(AuthenticationToken token) {
    return ((UsernamePasswordToken) token).getUsername();
  }
}
