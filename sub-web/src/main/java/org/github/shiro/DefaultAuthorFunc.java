package org.github.shiro;

import lombok.NonNull;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.github.web.model.shiro.AuthorInfo;
import org.github.web.model.shiro.UserDTO;
import org.github.web.system.service.IShiroService;

import java.util.List;
import java.util.Objects;

import static com.google.common.collect.ImmutableSet.toImmutableSet;
import static java.util.Arrays.stream;
import static java.util.Objects.requireNonNull;
import static org.github.spring.bootstrap.AppCtxHolder.getAppCtx;

public class DefaultAuthorFunc implements AuthorFunc {
    @Override
    public @NonNull AuthorizationInfo apply(@NonNull PrincipalCollection principals) {
        UserDTO user = (UserDTO) principals.getPrimaryPrincipal();
        val appCtx = getAppCtx();
        val shiroService = appCtx.getBean(IShiroService.class);
        val list = shiroService.queryAuthorInfo(requireNonNull(user.getUserId()));
        val roles = list.stream()
                .map(AuthorInfo::getRoleCode)
                .filter(StringUtils::isNotBlank)
                .collect(toImmutableSet());
        val perms = list.stream()
                .map(AuthorInfo::getPerms)
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .filter(Objects::nonNull)
                .flatMap(v -> stream(v.split(",")))
                .collect(toImmutableSet());
        val info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(perms);
        return info;
    }
}
