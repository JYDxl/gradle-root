package org.github.spring.restful.file;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;

import static com.google.common.io.ByteStreams.copy;

class FILEImpl implements FILE {
  @Nonnull
  private final String name;

  @Nonnull
  private final InputStream input;

  FILEImpl(@Nonnull String name, @Nonnull InputStream input) {
    this.name = name;
    this.input = input;
  }

  @Override
  public void collect(@Nonnull HttpServletRequest req, @Nonnull HttpServletResponse res) throws Exception {
    res.addHeader("Content-Disposition", "attachment;filename=" + name);
    FILE.super.collect(req, res);
  }

  @Nonnull
  @Override
  public String get() {
    return name;
  }

  @Override
  public void accept(@Nonnull OutputStream output) throws Exception {
    try(input) {
      copy(input, output);
    }
  }

  @Override
  public String toString() {
    return name;
  }
}
