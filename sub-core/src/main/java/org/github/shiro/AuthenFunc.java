package org.github.shiro;

import lombok.NonNull;
import org.apache.shiro.authc.AuthenticationToken;

import java.util.function.Function;

public interface AuthenFunc extends Function<AuthenticationToken,PartAuthenticationInfo> {
  @Override
  @NonNull PartAuthenticationInfo apply(@NonNull AuthenticationToken token);
}
