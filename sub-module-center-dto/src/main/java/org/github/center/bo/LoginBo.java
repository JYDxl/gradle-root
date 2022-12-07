package org.github.center.bo;

import javax.validation.constraints.NotBlank;
import lombok.*;
import org.github.core.base.IParam;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginBo implements IParam {
  /** 用户名 */
  @NotBlank(message = "用户名不能为空")
  private String username;

  /** 密码 */
  @NotBlank(message = "密码不能为空")
  private String password;
}
