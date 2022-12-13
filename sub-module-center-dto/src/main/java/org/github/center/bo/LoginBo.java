package org.github.center.bo;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.github.core.base.IBo;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginBo implements IBo {
  @ApiModelProperty(value = "用户名", required = true)
  @NotNull(message = "用户名不能为空")
  private String name;

  @ApiModelProperty(value = "密码", required = true)
  @NotNull(message = "密码不能为空")
  private String pwd;
}
