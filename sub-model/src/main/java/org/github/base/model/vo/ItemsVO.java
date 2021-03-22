package org.github.base.model.vo;

import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.github.base.IModel;

@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
public class ItemsVO implements IModel {
  private String itemId;

  private String itemName;

  private String itemUrl;

  private LocalDateTime createdTime;
}
