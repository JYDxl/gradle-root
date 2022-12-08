package org.github.web.model.bo;

import lombok.*;
import org.github.core.base.PageBo;
import javax.annotation.Nullable;

@EqualsAndHashCode(callSuper = true)
@Data
public class ItemSearchByCatBO extends PageBo {
  private @Nullable Integer catId;
  private @Nullable String  sort;
}
