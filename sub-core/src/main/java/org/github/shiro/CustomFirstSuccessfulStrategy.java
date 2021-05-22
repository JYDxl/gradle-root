package org.github.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.FirstSuccessfulStrategy;
import org.apache.shiro.realm.Realm;

public class CustomFirstSuccessfulStrategy extends FirstSuccessfulStrategy {
  public CustomFirstSuccessfulStrategy() {
    setStopAfterFirstSuccess(true);
  }

  @Override
  public AuthenticationInfo afterAttempt(Realm realm, AuthenticationToken token, AuthenticationInfo singleRealmInfo, AuthenticationInfo aggregateInfo, Throwable throwable) throws AuthenticationException {
    if (throwable == null) return super.afterAttempt(realm, token, singleRealmInfo, aggregateInfo, null);
    throw (throwable instanceof AuthenticationException ? ((AuthenticationException) throwable) : new AuthenticationException(throwable));
  }
}
