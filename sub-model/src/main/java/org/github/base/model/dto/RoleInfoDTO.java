package org.github.base.model.dto;

import java.util.List;
import lombok.*;
import org.github.base.entity.PermissionEntity;
import org.github.base.entity.RoleEntity;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class RoleInfoDTO extends RoleEntity {
  private List<PermissionEntity> permissionList;
}
