package org.github.center.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.github.core.base.CodeType;
import org.github.mysql.center.entity.SysUserMbpPo;
import static org.github.center.dict.AccountStatus.ACCOUNT_STATUS_DICT;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoginVo extends SysUserMbpPo {
  @ApiModelProperty("令牌")
  private String token;

  @ApiModelProperty("账号状态名称")
  @CodeType(type = ACCOUNT_STATUS_DICT, field = ACCOUNT_STATUS_PROP)
  private String accountStatusName;
}
