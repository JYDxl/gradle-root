package org.github.spring.restful.file;

import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.*;
import static com.google.common.io.ByteStreams.*;

@Data
class FILEImpl implements FILE {
  private final @NonNull String name;

  private final @NonNull InputStream input;

  @Override
  public void collect(@NonNull HttpServletRequest req, @NonNull HttpServletResponse res) throws Exception {
    res.addHeader("Content-Disposition", "attachment;filename=" + name);
    FILE.super.collect(req, res);
  }

  @Override
  public void accept(@NonNull OutputStream output) throws Exception {
    try (val in = input) {
      copy(in, output);
    }
  }

  @Override
  public @NonNull String get() {
    return name;
  }

  @Override
  public String toString() {
    return name;
  }
}
