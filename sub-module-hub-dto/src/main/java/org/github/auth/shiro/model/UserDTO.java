package org.github.auth.shiro.model;

import javax.annotation.Nullable;
import lombok.*;
import org.github.mysql.mydb.base.entity.SysUserEntity;
import static java.util.Objects.*;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class UserDTO extends SysUserEntity {
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

  public long getId() {
    return requireNonNull(super.getUserId());
  }
}
