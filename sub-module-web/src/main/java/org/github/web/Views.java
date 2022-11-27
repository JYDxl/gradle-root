package org.github.web;

import lombok.*;
import org.github.spring.restful.view.VIEW;

public enum Views implements VIEW {
  INDEX("index"),
  INDEX_V1("index_v1");
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
