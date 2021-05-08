package org.github.system.shiro;

import lombok.val;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.github.base.entity.PermissionEntity;
import org.github.util.FuncUtil;
import org.github.web.model.dto.RoleInfoDTO;
import org.github.web.model.dto.UserInfoDTO;
import org.github.web.service.ICustomUserService;

import java.util.Objects;
import java.util.function.Function;

import static com.google.common.collect.ImmutableSet.toImmutableSet;
import static org.github.spring.bootstrap.AppCtxHolder.getAppCtx;
import static org.github.util.FuncUtil.stream;

public abstract class AbstractRealm extends AuthorizingRealm {
  public AbstractRealm(CredentialsMatcher matcher) {
    super(matcher);
    setAuthenticationCachingEnabled(true);
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

  @Override
  protected Object getAuthenticationCacheKey(PrincipalCollection principals) {
    return ((UserInfoDTO) principals.getPrimaryPrincipal()).getUsername();
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    if (token.getPrincipal() == null) throw new AuthenticationException("用户名不能为空");
    if (token.getCredentials() == null) throw new AuthenticationException("密码不能为空");

    val username = getUsername(token);
    val userService = getAppCtx().getBean(ICustomUserService.class);
    val user = userService.queryUserInfo(username);
    val source = user.getSalt() != null ? new CustomByteSource(user.getSalt()) : new CustomByteSource();

    return new SimpleAuthenticationInfo(user, user.getPassword(), source, getName());
  }

  protected abstract String getUsername(AuthenticationToken token);

  @Override
  public String getName() {
    return getClass().getName();
  }
}
