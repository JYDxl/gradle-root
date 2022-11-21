package org.github.base;

import static cn.hutool.core.bean.BeanUtil.*;

public interface IParam extends IJson {
  default void trim() {
    trimStrFields(this);
  }
}
