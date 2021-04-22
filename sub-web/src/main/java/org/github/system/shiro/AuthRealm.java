package org.github.system.shiro;

import java.util.Map;
import lombok.*;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import com.google.common.collect.ImmutableListMultimap;
import static org.apache.shiro.util.ByteSource.Util.*;

public class AuthRealm extends AuthorizingRealm {
  private final Map<String,String>                   userMap = Map.of(
    "admin", new SimpleHash(Sha256Hash.ALGORITHM_NAME, "admin", "admin", 1024).toHex(),
    "jack", new SimpleHash(Sha256Hash.ALGORITHM_NAME, "jack", "jack", 1024).toHex(),
    "xd", new SimpleHash(Sha256Hash.ALGORITHM_NAME, "xd", "xd", 1024).toHex()
  );
  private final ImmutableListMultimap<String,String> roleMap = ImmutableListMultimap.of("admin", "*", "jack", "jack:*", "jack", "testJack:*");

  public AuthRealm(CredentialsMatcher matcher) {
    super(matcher);
    setAuthenticationCachingEnabled(true);
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    val username = ((String) token.getPrincipal());
    val password = userMap.get(username);
    if (password == null) return null;
    return new SimpleAuthenticationInfo(username, password, bytes(username), getName());
  }

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    val username    = ((String) principals.getPrimaryPrincipal());
    val permissions = roleMap.get(username);
    if (permissions.isEmpty()) return null;
    val info = new SimpleAuthorizationInfo();
    info.addRole(username);
    info.addStringPermissions(permissions);
    return info;
  }
}
