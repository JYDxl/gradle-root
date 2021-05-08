package org.github.system.shiro;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;

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
      verify(token.getCredentials().toString(), token.getPrincipal().toString(), info.getCredentials().toString());
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      if (e instanceof SignatureVerificationException) throw new AuthenticationException("签名无效");
      if (e instanceof AlgorithmMismatchException) throw new AuthenticationException("算法不匹配");
      if (e instanceof InvalidClaimException) throw new AuthenticationException("token内容不匹配");
      if (e instanceof TokenExpiredException) throw new AuthenticationException("token已过期");
      throw new AuthenticationException("token校验失败");
    }
  }
}
