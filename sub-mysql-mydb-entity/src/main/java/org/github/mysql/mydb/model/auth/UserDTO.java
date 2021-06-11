package org.github.mysql.mydb.model.auth;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import org.github.mysql.mydb.base.entity.SysUserEntity;
import org.github.shiro.User;

import javax.annotation.Nullable;

import static java.util.Objects.requireNonNull;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class UserDTO extends SysUserEntity implements User {
  private @Nullable String jsessionid;

  @Override
  public @NonNull String getUserId() {
    return requireNonNull(super.getId()).toString();
  }

  @Override
  public @NonNull String getUsername() {
    return requireNonNull(super.getUsername());
  }

  @Override
  public @NonNull String getPassword() {
    return requireNonNull(super.getPassword());
  }

  @Override
  public @Nullable String getSalt() {
    return super.getSalt();
  }
}
