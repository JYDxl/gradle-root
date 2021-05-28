package org.github.service;

import lombok.NonNull;
import org.github.shiro.AuthorInfo;
import org.github.shiro.User;

import java.util.List;

public interface IShiroService {
    @NonNull List<AuthorInfo> queryAuthorInfo(@NonNull String userId);

    @NonNull User queryUser(@NonNull String username);
}
