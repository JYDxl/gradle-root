package org.github.shiro;

import lombok.Data;

import javax.annotation.Nullable;

@Data
public class JWTLogin {
  private @Nullable String username;

  private @Nullable String password;
}
