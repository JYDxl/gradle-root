package org.github.shiro;

import java.util.Set;
import lombok.*;
import static com.google.common.base.Splitter.*;
import static com.google.common.collect.ImmutableSet.*;

@Data
public class AuthorInfo {
  private String roleCode;

  private String permCodes;

  public @NonNull Set<String> getPermCodeSet() {
    return on(',').splitToStream(permCodes).collect(toImmutableSet());
  }
}
