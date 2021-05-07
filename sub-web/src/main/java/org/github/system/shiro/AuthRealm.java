package org.github.system.shiro;

import java.util.Objects;
import java.util.function.Function;
import lombok.*;
import org.github.base.entity.PermissionEntity;
import org.github.util.FuncUtil;
import org.github.web.model.dto.RoleInfoDTO;
import org.github.web.model.dto.UserInfoDTO;
import org.github.web.service.ICustomUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import static com.google.common.collect.ImmutableSet.*;
import static org.apache.commons.lang3.StringUtils.*;
import static org.github.spring.bootstrap.AppCtxHolder.*;
import static org.github.util.FuncUtil.*;

public class AuthRealm extends AuthorizingRealm {
  public AuthRealm(CredentialsMatcher matcher) {
    super(matcher);
    setAuthenticationCachingEnabled(true);
    setAuthenticationCacheName("authen");
    setAuthorizationCacheName("author");
  }

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    val user = ((UserInfoDTO) principals.getPrimaryPrincipal());
    // val userService = getAppCtx().getBean(ICustomUserService.class);
    // val user        = userService.queryUserInfo(username);
    // requireNonNull(user);
    val roles       = stream(user.getRoleList()).map(RoleInfoDTO::getName).filter(Objects::nonNull).collect(toImmutableSet());
    val permissions = stream(user.getRoleList()).flatMap(Function.<RoleInfoDTO>identity().andThen(RoleInfoDTO::getPermissionList).andThen(FuncUtil::stream)).map(PermissionEntity::getName).filter(Objects::nonNull).collect(toImmutableSet());
    val info        = new SimpleAuthorizationInfo();
    info.setRoles(roles);
    info.setStringPermissions(permissions);
    return info;
  }

  @Override protected Object getAuthenticationCacheKey(PrincipalCollection principals) {
    return ((UserInfoDTO) principals.getPrimaryPrincipal()).getUsername();
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    UsernamePasswordToken token    = (UsernamePasswordToken) authenticationToken;
    val                   username = ((String) token.getPrincipal());
    if (isBlank(username)) return null;

    val userService = getAppCtx().getBean(ICustomUserService.class);
    val user        = userService.queryUserInfo(username);
    if (user == null) return null;

    return new SimpleAuthenticationInfo(user, user.getPassword(), new CustomByteSource(user.getSalt()), getName());
  }

  @Override
  public String getName() {
    return getClass().getName();
  }
}
