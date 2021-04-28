package org.github.web.model.vo;

import lombok.Data;

@Data
public class ItemSearchVO {
  private String  itemId;
  private String  itemName;
  private Integer sellCounts;
  private String  imgUrl;
  private Integer price;
}
