package org.github.web.model.bo;

import lombok.*;
import org.github.base.PageParam;
import javax.annotation.Nullable;

@EqualsAndHashCode(callSuper = true)
@Data
public class ItemCommentBO extends PageParam {
  private @Nullable String  itemId;
  private @Nullable Integer level;
}
