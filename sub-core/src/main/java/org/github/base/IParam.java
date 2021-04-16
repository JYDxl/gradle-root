package org.github.base;

import java.io.Serializable;
import org.github.ops.SpringsKt;

public interface IParam extends Serializable {
  default String json() {
    return SpringsKt.json(this, null);
  }

  default Object valid() {
    return this;
  }
}
