package org.github.web.model.bo;

import javax.validation.constraints.NotBlank;
import lombok.*;
import org.github.base.IParam;
import org.github.mysql.web.base.entity.AclRoleEntity;
import org.jetbrains.annotations.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class RoleSaveBo extends AclRoleEntity implements IParam {
  @NotBlank(message = "角色名称不能为空")
  @Override
  public String getRoleName() {
    return super.getRoleName();
  }

  @NotBlank(message = "角色编码不能为空")
  @Override
  public String getRoleCode() {
    return super.getRoleCode();
  }

  @NotNull
  @Override
  public String toString() {
    return get();
  }
}
