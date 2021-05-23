package org.github.service;

import lombok.NonNull;

import java.util.List;
import org.github.shiro.AuthorInfo;
import org.github.shiro.User;

public interface IShiroService {
  @NonNull List<AuthorInfo> queryAuthorInfo(@NonNull String userId);

  @NonNull User queryUser(@NonNull String username);
}
