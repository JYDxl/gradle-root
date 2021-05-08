package org.github.shiro;

import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.function.Function;

public interface AuthorFunc extends Function<PrincipalCollection,AuthorizationInfo> {}
