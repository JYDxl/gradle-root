package org.github.web;

import lombok.*;
import org.github.spring.restful.view.VIEW;

public enum Views implements VIEW {
  INDEX("frame/index"),
  MAIN("frame/main"),
  ROLE("frame/role/index"),
  ;
  private final String view;

  Views(String view) {
    this.view = view;
  }

  @Override
  @NonNull
  public String get() {
    return view;
  }
}
