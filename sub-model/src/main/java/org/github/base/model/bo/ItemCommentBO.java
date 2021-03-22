package org.github.base.model.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.github.base.PageModel;
import static com.google.common.base.Preconditions.*;
import static org.apache.commons.lang3.StringUtils.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class ItemCommentBO extends PageModel {
  private String itemId;

  private Integer level;

  @Override
  public ItemCommentBO valid() {
    checkArgument(isNotBlank(itemId), "itemId不能为空");
    checkArgument(level == null || (level >= 1 && level <= 3), "level必须在1~3之间（包括）");
    return this;
  }
}
