package org.github.shiro;

import lombok.Data;

@Data
public class PartAuthenticationInfo {
  private final Object principal;

  private final Object hashedCredentials;

  private final Object salt;
}
