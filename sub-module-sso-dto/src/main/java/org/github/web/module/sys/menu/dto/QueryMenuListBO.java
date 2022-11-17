package org.github.web.module.sys.menu.dto;

import javax.annotation.Nullable;
import lombok.*;
import org.github.base.PageParam;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class QueryMenuListBO extends PageParam {
  private @Nullable String name;
}
