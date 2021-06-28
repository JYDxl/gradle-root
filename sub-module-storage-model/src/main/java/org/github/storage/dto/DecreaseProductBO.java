package org.github.storage.dto;

import lombok.*;
import org.github.base.IParam;

@Data
public class DecreaseProductBO implements IParam {
  private Long productId;

  private Integer count;
}
