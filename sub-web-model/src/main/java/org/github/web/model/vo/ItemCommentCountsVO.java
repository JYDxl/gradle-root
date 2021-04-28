package org.github.web.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.github.base.IParam;

@AllArgsConstructor
@Data
public class ItemCommentCountsVO implements IParam {
  private Integer totalCounts;

  private Integer goodCounts;

  private Integer normalCounts;

  private Integer badCounts;
}
