package org.github.center.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.github.core.base.IBo;
import static cn.hutool.crypto.symmetric.SymmetricAlgorithm.AES;

@ApiModel("注册参数")
@Data
public class RegisterBo implements IBo {
  @ApiModelProperty(value = "用户名", required = true)
  @NotNull(message = "用户名不能为空")
  private String username;

  @ApiModelProperty(value = "密码", required = true)
  @NotNull(message = "密码不能为空")
  private String password;

  @ApiModelProperty(value = "加密方式", required = true, example = "AES")
  @NotNull(message = "加密方式不能为空")
  private String algorithm = AES.getValue();
}
