package org.github.order.dto;

import lombok.*;
import org.github.base.IParam;

@Data
public class UpdateOrderStatusBO implements IParam {
  private Long userId;

  private Integer status;

  @Override
  public @NonNull UpdateOrderStatusBO valid() {
    return this;
  }
}
