package org.github.core.base;

import java.io.Serializable;
import java.util.function.Supplier;
import lombok.*;

public interface IJson extends Serializable, Supplier<String> {
  @Override
  @NonNull
  default String get() {
    return org.github.core.spring.ops.SpringKt.json(this);
  }
}
