package org.github.center.bo;

import javax.annotation.Nullable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.github.core.base.PageBo;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class QueryMenuListBO extends PageBo {
  private @Nullable String name;
}
