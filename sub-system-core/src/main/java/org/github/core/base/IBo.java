package org.github.core.base;

import static cn.hutool.core.bean.BeanUtil.*;

public interface IBo extends IJson {
  default void trim() {
    trimStrFields(this);
  }
}
