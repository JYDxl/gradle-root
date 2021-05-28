package org.github.service.impl;

import lombok.NonNull;
import lombok.val;
import org.github.auth.feign.IServiceProviderAuthServer;
import org.github.service.IShiroService;
import org.github.service.ISystemService;
import org.github.shiro.AuthorInfo;
import org.github.shiro.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.requireNonNull;

@Service
public class ShiroServiceImpl implements IShiroService {
    @Autowired
    private IServiceProviderAuthServer authServer;
    @Autowired
    private ISystemService systemService;

    @Override
    public @NonNull List<AuthorInfo> queryAuthorInfo(@NonNull String userId) {
        val token = systemService.token();
        return requireNonNull(authServer.auth(token, userId).getData());
    }

    @Override
    public @NonNull User queryUser(@NonNull String username) {
        val token = systemService.token();
        return requireNonNull(authServer.user(token, username).getData());
    }
}
