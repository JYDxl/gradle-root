package org.github.system.shiro;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

public class AuthRealm extends AbstractRealm {
    public AuthRealm(CredentialsMatcher matcher) {
        super(matcher);
    }

    @Override
    protected String getUsername(AuthenticationToken authenticationToken) {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        return token.getUsername();
    }
}
