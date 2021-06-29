package org.github.account.dto;

import java.math.BigDecimal;
import lombok.*;
import org.github.base.IParam;

import javax.annotation.Nullable;

@Data
public class DecreaseAccountBO implements IParam {
  private @Nullable Long productId;

  private @Nullable BigDecimal money;
}
