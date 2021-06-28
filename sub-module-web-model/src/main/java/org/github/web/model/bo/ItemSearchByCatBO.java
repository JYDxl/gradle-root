package org.github.web.model.bo;

import lombok.*;
import org.github.base.PageParam;
import javax.annotation.Nullable;

@EqualsAndHashCode(callSuper = true)
@Data
public class ItemSearchByCatBO extends PageParam {
  private @Nullable Integer catId;
  private @Nullable String  sort;
}
