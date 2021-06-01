package org.github.shiro;

import lombok.val;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSessionStorageEvaluator;

import static com.google.common.collect.ImmutableSet.of;
import static java.util.Optional.ofNullable;

public class CustomWebSessionStorageEvaluator extends DefaultWebSessionStorageEvaluator {
  @Override
  public boolean isSessionStorageEnabled(Subject subject) {
    val realmNames = ofNullable(subject.getPrincipals()).map(PrincipalCollection::getRealmNames).orElse(of());
    return realmNames.contains(WEBRealm.class.getName()) || super.isSessionStorageEnabled(subject);
  }
}
