package org.github.web.system;

import lombok.*;
import org.github.web.model.shiro.UserDTO;

public interface IShiroService {
  @NonNull UserDTO queryUser(@NonNull String username);
}
