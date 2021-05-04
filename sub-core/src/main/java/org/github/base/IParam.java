package org.github.base;

import lombok.*;

public interface IParam extends IJson {
  @NonNull
  default Object valid() {
    return this;
  }
}
