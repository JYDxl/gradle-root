package org.github.web.service;

import java.util.List;
import java.util.Set;
import lombok.*;
import org.github.base.entity.UserEntity;
import org.github.web.model.dto.UserInfoDTO;

public interface ICustomUserService {
  @NonNull Set<String> queryPermissions(@NonNull Integer userId);

  @NonNull Set<String> queryRoles(@NonNull Integer userId);

  UserEntity queryUser(@NonNull String username);

  @NonNull List<UserInfoDTO> queryUserInfo(@NonNull String username);
}
