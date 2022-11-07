package org.github.web.module.index;

import javax.validation.constraints.NotNull;
import lombok.*;
import org.github.base.IParam;

@Data
public class LoginBo implements IParam {
  @NotNull(message = "用户名不能为空")
  private String username;

  @NotNull(message = "密码不能为空")
  private String password;
}
