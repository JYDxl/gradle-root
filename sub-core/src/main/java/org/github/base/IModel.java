package org.github.base;

import java.io.Serializable;

public interface IModel extends Serializable {
  default Object valid() {
    return this;
  }
}
