package org.github.account.dto;

import java.math.BigDecimal;
import lombok.*;
import org.github.base.IParam;

@Data
public class DecreaseAccountBO implements IParam {
  private Long productId;

  private BigDecimal money;
}
