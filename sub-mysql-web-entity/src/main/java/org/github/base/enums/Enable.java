package org.github.base.enums;

import lombok.NonNull;
import org.github.base.IEnum;

public enum Enable implements IEnum<Integer,String> {
  disabled(0, "禁用"),
  enabled(1, "启用");

  private final Integer code;

  private final String value;

  Enable(Integer code, String value) {
    this.code = code;
    this.value = value;
  }

  @Override
  public @NonNull Integer getCode() {
    return code;
  }

  @Override
  public @NonNull String getValue() {
    return value;
  }
}
