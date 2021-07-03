package org.github.mysql.leadnews.common.dto;

import org.github.shiro.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class UserDTO implements User {
  @Override public long getId() {
    return 0;
  }

  @NotNull @Override public String getUsername() {
    return null;
  }

  @NotNull @Override public String getPassword() {
    return null;
  }

  @Nullable @Override public String getSalt() {
    return null;
  }
}
