package org.github.shiro;

import lombok.NonNull;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.function.Function;

public interface AuthorFunc extends Function<PrincipalCollection, AuthorizationInfo> {
    @Override
    @NonNull AuthorizationInfo apply(@NonNull PrincipalCollection principalCollection);
}
