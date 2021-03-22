package org.github.base.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.github.base.IModel;

@AllArgsConstructor
@Data
public class ItemCommentCountsVO implements IModel {
  private Integer totalCounts;

  private Integer goodCounts;

  private Integer normalCounts;

  private Integer badCounts;
}
