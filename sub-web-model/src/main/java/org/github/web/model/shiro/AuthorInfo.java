package org.github.web.model.shiro;

import lombok.Data;

import javax.annotation.Nullable;
import java.util.List;

@Data
public class AuthorInfo {
  private @Nullable String role;

  private @Nullable List<String> perms;
}
