package org.github.system.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;

import static org.github.system.shiro.JWTUtil.verify;

@Slf4j
public class JWTRealm extends AbstractRealm {
  public JWTRealm() {
    super(null);
    setAuthenticationCacheName("authen:jwt");
    setAuthorizationCacheName("author");
  }

  @Override
  protected String getUsername(AuthenticationToken token) {
    return ((JWTToken) token).getUsername();
  }

  @Override
  public boolean supports(AuthenticationToken token) {
    return token instanceof JWTToken;
  }

  @Override
  protected void assertCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) throws AuthenticationException {
    try {
      //TODO 异常分类
      verify(token.getCredentials().toString(), token.getPrincipal().toString(), info.getCredentials().toString());
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      String msg = "Submitted credentials for token [" + token + "] did not match the expected credentials.";
      throw new IncorrectCredentialsException(msg);
    }
  }
}
