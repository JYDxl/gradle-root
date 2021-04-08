package org.github.base;

import java.io.Serializable;
import org.github.ops.spring.SpringOpsKt;

public interface IParam extends Serializable {
  default String json() {
    return SpringOpsKt.json(this, null);
  }

  default Object valid() {
    return this;
  }
}
