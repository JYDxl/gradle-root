package org.github.base.model.dto;

import java.util.List;
import lombok.*;
import org.github.base.entity.UserEntity;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class UserInfoDTO extends UserEntity {
  private List<RoleInfoDTO> roleList;
}
