package org.github.base;

import java.io.Serializable;
import java.util.function.Supplier;
import lombok.*;
import static org.github.spring.ops.SpringsKt.*;

public interface IJson extends Serializable, Supplier<String> {
  @Override
  default @NonNull String get() {
    return json(this);
  }
}
