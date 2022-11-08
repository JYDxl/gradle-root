package org.github.web.module.index;

import javax.validation.constraints.NotNull;
import lombok.*;
import org.github.base.IParam;
import static cn.hutool.crypto.symmetric.SymmetricAlgorithm.*;

@Data
public class RegisterBo implements IParam {
  @NotNull(message = "用户名不能为空")
  private String username;

  @NotNull(message = "密码不能为空")
  private String password;

  @NotNull(message = "加密方式不能为空")
  private String algorithm = AES.getValue();
}
