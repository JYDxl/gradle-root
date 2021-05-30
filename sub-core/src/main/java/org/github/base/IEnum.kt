package org.github.base;

import lombok.*;

public interface IEnum<C, V> {
  @NonNull C getCode();

  @NonNull V getValue();
}
