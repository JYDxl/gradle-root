package org.github.system.shiro;

import lombok.val;
import org.apache.shiro.authc.*;
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
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.github.spring.bootstrap.AppCtxHolder.getAppCtx;
import static org.github.util.FuncUtil.stream;

public abstract class AbstractRealm extends AuthorizingRealm {
    public AbstractRealm(CredentialsMatcher matcher) {
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
        val roles = stream(user.getRoleList()).map(RoleInfoDTO::getName).filter(Objects::nonNull).collect(toImmutableSet());
        val permissions = stream(user.getRoleList()).flatMap(Function.<RoleInfoDTO>identity().andThen(RoleInfoDTO::getPermissionList).andThen(FuncUtil::stream)).map(PermissionEntity::getName).filter(Objects::nonNull).collect(toImmutableSet());
        val info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permissions);
        return info;
    }

    @Override
    protected Object getAuthenticationCacheKey(PrincipalCollection principals) {
        return ((UserInfoDTO) principals.getPrimaryPrincipal()).getUsername();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        val username = getUsername(authenticationToken);
        if (isBlank(username)) return null;

        val userService = getAppCtx().getBean(ICustomUserService.class);
        val user = userService.queryUserInfo(username);
        if (user == null) return null;
        val source = user.getSalt() != null ? new CustomByteSource(user.getSalt()) : new CustomByteSource();
        return new SimpleAuthenticationInfo(user, user.getPassword(), source, getName());
    }

    protected abstract String getUsername(AuthenticationToken token);

    @Override
    public String getName() {
        return getClass().getName();
    }
}
