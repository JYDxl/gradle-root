package org.github.order.dto;

import lombok.*;
import org.github.base.IParam;

import javax.annotation.Nullable;

@Data
public class UpdateOrderStatusBO implements IParam {
  private @Nullable Long userId;

  private @Nullable Integer status;
}
