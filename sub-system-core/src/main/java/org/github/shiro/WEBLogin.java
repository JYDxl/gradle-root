package org.github.shiro;

import lombok.Data;

import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import org.github.base.IParam;

@Data
public class WEBLogin implements IParam {
  @NotBlank
  private String  username;
  @NotBlank
  private String  password;
  private boolean rememberMe = false;
  @Nullable
  private String  host;
}
