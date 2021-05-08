package org.github.shiro;

import lombok.val;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.github.base.entity.PermissionEntity;
import org.github.util.FuncUtil;
import org.github.web.model.dto.RoleInfoDTO;
import org.github.web.model.dto.UserInfoDTO;

import java.util.Objects;
import java.util.function.Function;

import static com.google.common.collect.ImmutableSet.toImmutableSet;
import static org.github.util.FuncUtil.stream;

public class WebAuthorFunc implements AuthorFunc {
  @Override
  public AuthorizationInfo apply(PrincipalCollection principals) {
    val user        = ((UserInfoDTO) principals.getPrimaryPrincipal());
    val roles       = stream(user.getRoleList()).map(RoleInfoDTO::getName).filter(Objects::nonNull).collect(toImmutableSet());
    val permissions = stream(user.getRoleList()).flatMap(Function.<RoleInfoDTO>identity().andThen(RoleInfoDTO::getPermissionList).andThen(FuncUtil::stream)).map(PermissionEntity::getName).filter(Objects::nonNull).collect(toImmutableSet());
    val info        = new SimpleAuthorizationInfo();
    info.setRoles(roles);
    info.setStringPermissions(permissions);
    return info;
  }
}
