package org.github.web.enums;

import lombok.*;
import org.github.base.IEnum;

public enum EnableEnum implements IEnum<Integer,String> {
  disabled(0, "禁用"),
  enabled(1, "启用");

  private final Integer code;

  private final String value;

  EnableEnum(Integer code, String value) {
    this.code = code;
    this.value = value;
  }

  @NonNull @Override public Integer getCode() {
    return code;
  }

  @NonNull @Override public String getValue() {
    return value;
  }
}
