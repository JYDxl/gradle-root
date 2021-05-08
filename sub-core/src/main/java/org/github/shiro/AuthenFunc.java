package org.github.shiro;

import org.apache.shiro.authc.AuthenticationToken;

import java.util.function.Function;

public interface AuthenFunc extends Function<AuthenticationToken,PartAuthenticationInfo> {}
