package org.github.shiro;

import lombok.NonNull;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;

public class DefaultAuthorFunc implements AuthorFunc {
  @Override
  public @NonNull AuthorizationInfo apply(@NonNull PrincipalCollection principals) {
    //TODO 待实现
    return new SimpleAuthorizationInfo();
  }
}
