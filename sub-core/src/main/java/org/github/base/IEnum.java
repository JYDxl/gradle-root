package org.github.base;

import java.util.Map;
import java.util.function.Supplier;
import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

public interface IEnum<C, E extends IEnum<C,E,V>, V> extends Supplier<E[]> {
  default Map<C,V> asMap() {
    return stream(get()).collect(toUnmodifiableMap(IEnum::getCode, IEnum::getValue));
  }

  C getCode();

  V getValue();

  default V turn(C c) {
    if (c == null) return null;
    for (E e : get()) {
      if (c.equals(e.getCode())) return e.getValue();
    }
    return null;
  }
}
