package org.github.shiro;

import lombok.*;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import static org.apache.commons.lang3.StringUtils.*;

public abstract class AbstractRealm extends AuthorizingRealm {

  private final AuthorFunc author;

  private final AuthenFunc authen;

  public AbstractRealm(CredentialsMatcher matcher, AuthorFunc author, AuthenFunc authen) {
    super(matcher);
    this.author = author;
    this.authen = authen;
    setAuthenticationCachingEnabled(true);
  }

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    return author.apply(principals);
  }

  @Override
  protected Object getAuthenticationCacheKey(PrincipalCollection principals) {
    return ((User) principals.getPrimaryPrincipal()).getUsername();
  }

  @Override
  protected Object getAuthorizationCacheKey(PrincipalCollection principals) {
    return ((User) principals.getPrimaryPrincipal()).getUsername();
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    if (isBlank((CharSequence) token.getPrincipal())) throw new AuthenticationException("用户名不能为空");
    if (token.getCredentials() == null || (token.getCredentials() instanceof CharSequence && isBlank((CharSequence) token.getCredentials()))) throw new AuthenticationException("密码不能为空");
    val info   = authen.apply(token);
    val source = info.getSalt() != null ? new CustomByteSource(info.getSalt()) : new CustomByteSource();
    return new SimpleAuthenticationInfo(info.getPrincipal(), info.getHashedCredentials(), source, getName());
  }

  @Override
  public String getName() {
    return getClass().getName();
  }
}
