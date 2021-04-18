package org.github.base;

import java.io.Serializable;
import java.util.function.Supplier;
import static org.github.ops.SpringsKt.*;

public interface IJson extends Serializable, Supplier<String> {
  @Override
  default String get() {
    return json(this, null);
  }
}
