package org.github.base.enums;

import org.github.base.IEnum;

public enum SexEnum implements IEnum<Integer, String> {
  man(0, "男"),
  woman(1, "女");

  private final Integer code;

  private final String value;

  SexEnum(Integer code, String value) {
    this.code = code;
    this.value = value;
  }

  @Override
  public Integer getCode() {
    return code;
  }

  @Override
  public String getValue() {
    return value;
  }
}
