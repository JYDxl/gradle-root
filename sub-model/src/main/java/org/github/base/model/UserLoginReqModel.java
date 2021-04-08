package org.github.base.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.github.base.IParam;
import org.github.base.entity.UsersEntity;
import static com.google.common.base.Preconditions.*;
import static org.apache.commons.lang3.StringUtils.*;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class UserLoginReqModel extends UsersEntity implements IParam {
  @Override
  public UserLoginReqModel valid() {
    checkArgument(isNotBlank(getUsername()) && isNotBlank(getPassword()), "用户名或密码不能为空");
    checkArgument(getPassword().length() >= 6, "密码长度不能少于6位");
    return this;
  }
}
