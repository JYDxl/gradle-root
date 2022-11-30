package org.github.web;

import lombok.*;
import org.github.spring.restful.view.VIEW;

public enum Views implements VIEW {
  INDEX("/frame/index"),
  MAIN("/frame/main"),
  ROLE("/frame/role/index"),
  ROLE_CREATE("/frame/role/create"),
  ROLE_EDIT("/frame/role/edit"),
  SUCCESS("/frame/common/successPage"),
  ;
  private final String view;

  Views(String view) {
    this.view = view;
  }

  @Override
  public String toString() {
    return get();
  }

  @Override
  @NonNull
  public String get() {
    return view;
  }
}
