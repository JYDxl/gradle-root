package org.github.base;

import java.io.Serializable;
import java.util.function.Supplier;
import lombok.*;
import static org.github.spring.ops.SpringKt.*;

public interface IJson extends Serializable, Supplier<String> {
  @Override
  @NonNull
  default String get() {
    return json(this);
  }
}
