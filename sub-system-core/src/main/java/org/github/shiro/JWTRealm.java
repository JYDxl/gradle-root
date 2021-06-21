package org.github.shiro;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;

import static org.github.shiro.JWTUtil.verify;

@Slf4j
public class JWTRealm extends ShiroRealm {
  public JWTRealm(AuthorFunc author, AuthenFunc authen, String authenticationCacheName, String authorizationCacheName) {
    super(null, author, authen);
    setAuthenticationCacheName(authenticationCacheName);
    setAuthorizationCacheName(authorizationCacheName);
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
      log.info(e.getMessage(), e);
      if (e instanceof SignatureVerificationException) throw new AuthenticationException("签名验证异常");
      if (e instanceof AlgorithmMismatchException) throw new AuthenticationException("算法匹配异常");
      if (e instanceof InvalidClaimException) throw new AuthenticationException("内容匹配异常");
      if (e instanceof TokenExpiredException) throw new AuthenticationException("token已过期");
      throw new AuthenticationException("token校验失败");
    }
  }
}
