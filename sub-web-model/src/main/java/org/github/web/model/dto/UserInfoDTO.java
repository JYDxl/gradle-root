package org.github.web.model.dto;

import java.util.List;
import javax.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.github.base.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class UserInfoDTO extends UserEntity {
  private @Nullable List<RoleInfoDTO> roleList;

  @JsonProperty("token")
  private @Nullable String sessionId;

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
