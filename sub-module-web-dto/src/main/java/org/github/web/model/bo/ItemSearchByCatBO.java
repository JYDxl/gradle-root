package org.github.web.model.bo;

import javax.annotation.Nullable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.github.core.base.PageBo;

@EqualsAndHashCode(callSuper = true)
@Data
public class ItemSearchByCatBO extends PageBo {
  private @Nullable Integer catId;
  private @Nullable String  sort;
}
