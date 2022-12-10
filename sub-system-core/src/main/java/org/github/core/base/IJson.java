package org.github.core.base;

import java.io.Serializable;
import java.util.function.Supplier;
import lombok.NonNull;
import static org.github.core.spring.ops.SpringKt.json;

public interface IJson extends Serializable, Supplier<String> {
  @Override
  @NonNull
  default String get() {
    return json(this);
  }
}
