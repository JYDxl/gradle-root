package org.github.web.model.bo;

import lombok.*;
import org.github.base.PageParam;
import javax.annotation.Nullable;

@EqualsAndHashCode(callSuper = true)
@Data
public class ItemSearchBO extends PageParam {
  private @Nullable String keywords;
  private @Nullable String sort;
}
