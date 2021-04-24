package org.github.system.shiro;

import lombok.*;
import org.github.base.entity.UserEntity;
import org.github.web.service.ICustomUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.shiro.util.ByteSource.Util.*;

public class AuthRealm extends AuthorizingRealm {
  @Autowired
  private ICustomUserService userService;

  public AuthRealm(CredentialsMatcher matcher) {
    super(matcher);
    setAuthenticationCachingEnabled(true);
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    val username = ((String) token.getPrincipal());
    if (isBlank(username)) return null;

    val user = userService.queryUser(username);
    if (user == null) return null;

    return new SimpleAuthenticationInfo(user, user.getPassword(), bytes(user.getSalt()), getName());
  }

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    val user        = ((UserEntity) principals.getPrimaryPrincipal());
    val userId      = user.getId();
    val roles       = userService.queryRoles(userId);
    val permissions = userService.queryPermissions(userId);
    val info        = new SimpleAuthorizationInfo();
    info.setRoles(roles);
    info.setStringPermissions(permissions);
    return info;
  }
}
