package org.github.web.model.vo;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.github.base.IParam;

@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
public class CategoryVO implements IParam {
  private Integer id;

  private String name;

  private Integer type;

  private Integer fatherId;

  private List<SubCategoryVO> List;
}
