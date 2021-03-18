package org.github.base.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.github.base.IModel;
import org.github.base.entity.UsersEntity;
import static com.google.common.base.Preconditions.*;
import static org.apache.commons.lang3.StringUtils.*;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class UserRegisterModel extends UsersEntity implements IModel {
  private String confirmPassword;

  @Override
  public UserRegisterModel valid() {
    checkArgument(isNotBlank(getUsername()) && isNotBlank(getPassword()) && isNotBlank(getConfirmPassword()), "用户名或密码不能为空");
    checkArgument(getPassword().length() >= 6 && getConfirmPassword().length() >= 6, "密码长度不能少于6位");
    checkArgument(getPassword().equals(getConfirmPassword()), "两次密码输入不一致");
    return this;
  }
}
