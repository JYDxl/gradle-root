package org.github.base.model.vo;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.github.base.IParam;

@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
public class NewItemsVO implements IParam {
  private Integer rootCatId;

  private String rootCatName;

  private String slogan;

  private String catImage;

  private String bgColor;

  private List<ItemsVO> simpleItemList;
}
