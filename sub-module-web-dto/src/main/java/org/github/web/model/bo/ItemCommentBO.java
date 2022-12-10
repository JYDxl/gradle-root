package org.github.web.model.bo;

import javax.annotation.Nullable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.github.core.base.PageBo;

@EqualsAndHashCode(callSuper = true)
@Data
public class ItemCommentBO extends PageBo {
  private @Nullable String  itemId;
  private @Nullable Integer level;
}
