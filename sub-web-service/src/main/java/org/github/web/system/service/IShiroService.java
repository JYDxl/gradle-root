package org.github.web.system.service;

import lombok.*;
import org.github.web.model.shiro.AuthorInfo;
import org.github.web.model.shiro.UserDTO;

import java.util.List;

public interface IShiroService {
  @NonNull List<AuthorInfo> queryAuthorInfo(@NonNull Long userId);

  @NonNull UserDTO queryUser(@NonNull String username);
}
