package org.github.web.model.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.github.base.IParam;

@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
public class SubCategoryVO implements IParam {
  private Integer subId;

  private String subName;

  private Integer subType;

  private Integer subFatherId;
}
