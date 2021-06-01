package org.github.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;

public class WEBRealm extends AbstractRealm {
  public WEBRealm(CredentialsMatcher matcher, AuthorFunc author, AuthenFunc authen, String authenticationCacheName, String authorizationCacheName) {
    super(matcher, author, authen);
    setAuthenticationCacheName(authenticationCacheName);
    setAuthorizationCacheName(authorizationCacheName);
  }

  @Override
  protected void assertCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) throws AuthenticationException {
    if (!getCredentialsMatcher().doCredentialsMatch(token, info)) throw new IncorrectCredentialsException("用户名或密码错误");
  }
}
