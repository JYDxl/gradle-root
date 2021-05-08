package org.github.web.model.shiro;

import javax.annotation.Nullable;
import lombok.*;
import org.github.base.entity.SysUserEntity;
import org.github.shiro.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import static java.util.Objects.*;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class UserDTO extends SysUserEntity implements User {
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
  public @Nullable String getSalt() {
    return super.getSalt();
  }
}
