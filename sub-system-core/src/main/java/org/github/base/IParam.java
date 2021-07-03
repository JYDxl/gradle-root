package org.github.base;

import static cn.hutool.core.bean.BeanUtil.*;

public interface IParam extends IJson {
  default void trimFields() {
    trimStrFields(this);
  }

  default void valid() {}
}
