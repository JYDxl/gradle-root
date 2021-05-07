package org.github.system.shiro;

import lombok.Data;
import lombok.NonNull;
import org.apache.shiro.authc.AuthenticationToken;

@Data
public class JWTToken implements AuthenticationToken {
    @NonNull
    private final String username;
    @NonNull
    private final String token;

    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
