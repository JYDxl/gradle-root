package org.github.shiro;

import java.util.Set;
import lombok.*;
import org.github.service.IShiroService;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import static com.google.common.collect.ImmutableSet.*;
import static org.github.spring.bootstrap.AppCtxHolder.*;

public class DefaultAuthorFunc implements AuthorFunc {
  @Override
  public @NonNull AuthorizationInfo apply(@NonNull PrincipalCollection principals) {
    val user         = (User) principals.getPrimaryPrincipal();
    val appCtx       = getAppCtx();
    val shiroService = appCtx.getBean(IShiroService.class);
    val list         = shiroService.queryAuthorInfo(user.getId());
    val data         = list.getData();
    val roles        = data.stream().map(AuthorInfo::getRoleCode).collect(toImmutableSet());
    val perms        = data.stream().map(AuthorInfo::getPermCodeSet).flatMap(Set::stream).collect(toImmutableSet());
    val info         = new SimpleAuthorizationInfo();
    info.setRoles(roles);
    info.setStringPermissions(perms);
    return info;
  }
}
