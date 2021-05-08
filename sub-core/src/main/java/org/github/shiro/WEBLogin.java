package org.github.shiro;

import lombok.Data;

import javax.annotation.Nullable;

@Data
public class WEBLogin {
  private @Nullable String username;

  private @Nullable String password;

  private boolean rememberMe = false;

  private @Nullable String host;
}
