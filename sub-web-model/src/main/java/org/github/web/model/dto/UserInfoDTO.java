package org.github.web.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import org.github.base.entity.UserEntity;
import org.github.shiro.User;

import javax.annotation.Nullable;
import java.util.List;

import static java.util.Objects.requireNonNull;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class UserInfoDTO extends UserEntity implements User {
  private @Nullable List<RoleInfoDTO> roleList;

  private @Nullable String token;

  @Override
  public @NonNull String getUsername() {
    return requireNonNull(super.getUsername());
  }

  @JsonIgnore
  @Override
  public @NonNull String getPassword() {
    return requireNonNull(super.getPassword());
  }

  @JsonIgnore
  @Override
  public String getSalt() {
    return super.getSalt();
  }

  @Override
  public @NonNull String getUserId() {
    return requireNonNull(getId()).toString();
  }
}
