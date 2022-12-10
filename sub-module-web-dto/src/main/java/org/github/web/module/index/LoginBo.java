package org.github.web.module.index;

import javax.validation.constraints.NotNull;
import lombok.Data;
import org.github.core.base.IBo;

@Data
public class LoginBo implements IBo {
  /** 用户名 */
  @NotNull(message = "用户名不能为空")
  private String username;

  /** 密码 */
  @NotNull(message = "密码不能为空")
  private String password;
}
