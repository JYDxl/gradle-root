package org.github.web.model.bo;

import lombok.*;
import org.github.base.PageParam;
import static com.google.common.base.Preconditions.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class ItemSearchByCatBO extends PageParam {
  private Integer catId;

  private String sort;

  @Override
  public @NonNull ItemSearchByCatBO valid() {
    checkArgument(catId != null, "catId不能为空");
    return this;
  }
}
