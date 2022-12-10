package org.github.center.bo;

import javax.validation.constraints.NotNull;
import lombok.Data;
import org.github.core.base.IBo;
import static cn.hutool.crypto.symmetric.SymmetricAlgorithm.AES;

@Data
public class RegisterBo implements IBo {
  /** 用户名 */
  @NotNull(message = "用户名不能为空")
  private String username;

  /** 密码 */
  @NotNull(message = "密码不能为空")
  private String password;

  /** 加密方式 */
  @NotNull(message = "加密方式不能为空")
  private String algorithm = AES.getValue();
}
