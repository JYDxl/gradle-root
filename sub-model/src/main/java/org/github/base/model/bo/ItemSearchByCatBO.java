package org.github.base.model.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.github.base.PageModel;
import static com.google.common.base.Preconditions.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class ItemSearchByCatBO extends PageModel {
  private Integer catId;

  private String sort;

  @Override
  public ItemSearchByCatBO valid() {
    checkArgument(catId != null, "catId不能为空");
    return this;
  }
}
