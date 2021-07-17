package org.github.shiro;

import java.util.Set;
import javax.annotation.Nullable;
import lombok.*;
import org.apache.commons.lang3.StringUtils;
import static com.google.common.base.Splitter.*;
import static com.google.common.collect.ImmutableSet.*;
import static org.apache.commons.lang3.StringUtils.*;

@Data
public class AuthorInfo {
  private @Nullable String roleCode;

  private @Nullable String permCodes;

  public @NonNull Set<String> getPermCodeSet() {
    if (isBlank(permCodes)) return of();
    return on(',').splitToStream(permCodes).filter(StringUtils::isNotBlank).collect(toImmutableSet());
  }
}
