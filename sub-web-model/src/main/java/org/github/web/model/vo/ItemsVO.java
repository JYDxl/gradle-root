package org.github.web.model.vo;

import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.github.base.IParam;

@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
public class ItemsVO implements IParam {
  private String itemId;

  private String itemName;

  private String itemUrl;

  private LocalDateTime createdTime;
}
