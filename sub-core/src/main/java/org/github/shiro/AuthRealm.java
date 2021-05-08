package org.github.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;

public class AuthRealm extends AbstractRealm {
  public AuthRealm(CredentialsMatcher matcher, AuthorFunc author, AuthenFunc authen) {
    super(matcher, author, authen);
    setAuthenticationCacheName("authen:web");
    setAuthorizationCacheName("author");
  }

  @Override
  protected void assertCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) throws AuthenticationException {
    if (!getCredentialsMatcher().doCredentialsMatch(token, info)) throw new IncorrectCredentialsException("用户名或密码错误");
  }
}
