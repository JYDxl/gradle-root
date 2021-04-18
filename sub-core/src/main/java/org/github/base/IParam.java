package org.github.base;

public interface IParam extends IJson {
  default Object valid() {
    return this;
  }
}
