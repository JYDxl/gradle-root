package org.github.base;

import lombok.*;

public interface IParam extends IJson {
  default @NonNull Object valid() {
    return this;
  }
}
