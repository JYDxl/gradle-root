package org.github.base.model.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.github.base.IModel;

@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
public class SubCategoryVO implements IModel {
  private Integer subId;

  private String subName;

  private Integer subType;

  private Integer subFatherId;
}
