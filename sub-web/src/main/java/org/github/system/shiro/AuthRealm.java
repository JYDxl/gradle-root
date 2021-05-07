package org.github.system.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

public class AuthRealm extends AbstractRealm {
  public AuthRealm(CredentialsMatcher matcher) {
    super(matcher);
    setAuthenticationCacheName("authen:web");
    setAuthorizationCacheName("author");
  }

  @Override protected void assertCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) throws AuthenticationException {
    //TODO 异常分类处理
    super.assertCredentialsMatch(token, info);
  }

  @Override
  protected String getUsername(AuthenticationToken token) {
    return ((UsernamePasswordToken) token).getUsername();
  }
}
