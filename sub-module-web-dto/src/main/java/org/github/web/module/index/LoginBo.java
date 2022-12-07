package org.github.web.module.index;

import javax.validation.constraints.NotNull;
import lombok.*;
import org.github.core.base.IParam;

@Data
public class LoginBo implements IParam {
  /** 用户名 */
  @NotNull(message = "用户名不能为空")
  private String username;

  /** 密码 */
  @NotNull(message = "密码不能为空")
  private String password;
}
