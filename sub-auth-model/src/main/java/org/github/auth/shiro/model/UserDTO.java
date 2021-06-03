package org.github.auth.shiro.model;

import javax.annotation.Nullable;
import lombok.*;
import org.github.mysql.web.base.entity.SysUserEntity;
import org.github.shiro.User;
import static java.util.Objects.*;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class UserDTO extends SysUserEntity implements User {
  private @Nullable String jsessionid;

  @Override
  public @NonNull Long getUserId() {
    return requireNonNull(super.getUserId());
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
