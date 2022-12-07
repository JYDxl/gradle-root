package org.github.center.bo;

import javax.annotation.Nullable;
import lombok.*;
import org.github.core.base.PageParam;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class QueryMenuListBO extends PageParam {
  private @Nullable String name;
}
