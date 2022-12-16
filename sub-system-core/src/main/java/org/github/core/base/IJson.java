package org.github.core.base;

import java.io.Serializable;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;
import static org.github.core.spring.ops.SpringKt.json;

public interface IJson extends Serializable, Supplier<String> {
  @Override
  @NotNull
  default String get() {
    return json(this);
  }
}
