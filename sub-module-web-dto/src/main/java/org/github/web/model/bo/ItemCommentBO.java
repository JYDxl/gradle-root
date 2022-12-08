package org.github.web.model.bo;

import lombok.*;
import org.github.core.base.PageBo;
import javax.annotation.Nullable;

@EqualsAndHashCode(callSuper = true)
@Data
public class ItemCommentBO extends PageBo {
  private @Nullable String  itemId;
  private @Nullable Integer level;
}
