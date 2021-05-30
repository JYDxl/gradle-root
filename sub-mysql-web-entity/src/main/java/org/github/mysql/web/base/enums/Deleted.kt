package org.github.mysql.web.base.enums;

import lombok.NonNull;
import org.github.base.IEnum;

public enum Deleted implements IEnum<Integer,String> {
  exists(0, "未删除"),
  deleted(1, "已删除");

  private final Integer code;

  private final String value;

  Deleted(Integer code, String value) {
    this.code  = code;
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
