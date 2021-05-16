package org.github.web.enums;

import lombok.*;
import org.github.base.IEnum;

public enum MenuType implements IEnum<Integer,String> {
  //类型   0：目录   1：菜单   2：按钮
  directory(0, "目录"),
  menu(1, "菜单"),
  button(2, "按钮");

  private final Integer code;

  private final String value;

  MenuType(Integer code, String value) {
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
