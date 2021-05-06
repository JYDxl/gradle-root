package org.github.cache;

import java.util.function.UnaryOperator;

public interface CacheNameSupplier extends UnaryOperator<String> {
  @Override
  default String apply(String prefix) {
    return prefix + this;
  }
}
