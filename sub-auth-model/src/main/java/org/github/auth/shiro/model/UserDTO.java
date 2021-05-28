package org.github.auth.shiro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import org.github.mysql.web.base.entity.SysUserMbpEntity;
import org.github.shiro.User;

import javax.annotation.Nullable;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class UserDTO extends SysUserMbpEntity implements User {
  private @Nullable String token;

  @Override
  public @NonNull String getUsername() {
    return super.getUsername();
  }

  @JsonIgnore
  @Override
  public @NonNull String getPassword() {
    return super.getPassword();
  }

  @JsonIgnore
  @Override
  public @Nullable String getSalt() {
    return super.getSalt();
  }

  @Override
  public @NonNull Long getUserId() {
    return super.getUserId();
  }
}
