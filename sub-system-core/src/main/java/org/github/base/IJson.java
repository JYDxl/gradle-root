package org.github.base;

import java.io.Serializable;
import java.util.function.Supplier;
import lombok.*;
import static cn.hutool.core.bean.BeanUtil.*;
import static org.github.spring.ops.SpringKt.*;

public interface IJson extends Serializable, Supplier<String> {
  @Override
  default @NonNull String get() {
    return json(this);
  }

  default @NonNull Object trimFields() {
    return trimStrFields(this);
  }
}
