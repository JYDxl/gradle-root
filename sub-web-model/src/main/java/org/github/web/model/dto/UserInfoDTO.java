package org.github.web.model.dto;

import java.util.List;
import javax.annotation.Nullable;
import lombok.*;
import org.github.base.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class UserInfoDTO extends UserEntity {
  private @Nullable List<RoleInfoDTO> roleList;

  @JsonIgnore
  @Override
  public String getPassword() {
    return super.getPassword();
  }

  @JsonIgnore
  @Override
  public String getSalt() {
    return super.getSalt();
  }
}
