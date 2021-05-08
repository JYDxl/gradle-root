package org.github.web.enums;

import lombok.*;
import org.github.base.IEnum;

public enum UserStatusEnum implements IEnum<Integer,String> {
  //状态  0：禁用   1：正常
  disabled(0, "禁用"),
  enabled(1, "正常");

  private final Integer code;

  private final String value;

  UserStatusEnum(Integer code, String value) {
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
