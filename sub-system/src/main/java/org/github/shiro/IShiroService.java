package org.github.shiro;

import lombok.NonNull;

import java.util.List;

public interface IShiroService {
  @NonNull List<AuthorInfo> queryAuthorInfo(@NonNull String userId);

  @NonNull User queryUser(@NonNull String username);
}
