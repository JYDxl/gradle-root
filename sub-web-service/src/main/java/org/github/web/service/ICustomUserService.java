package org.github.web.service;

import java.util.Set;
import javax.annotation.Nullable;
import lombok.*;
import org.github.base.entity.UserEntity;
import org.github.web.model.dto.UserInfoDTO;

public interface ICustomUserService {
  @NonNull Set<String> queryPermissions(@NonNull Integer userId);

  @NonNull Set<String> queryRoles(@NonNull Integer userId);

  @Nullable UserEntity queryUser(@NonNull String username);

  @Nullable UserInfoDTO queryUserInfo(@NonNull String username);
}
