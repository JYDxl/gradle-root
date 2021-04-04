package org.github.spring.restful.file;

import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.*;
import static com.google.common.io.ByteStreams.*;

@Data
class FILEImpl implements FILE {
  @NonNull
  private final String name;

  @NonNull
  private final InputStream input;

  @Override
  public void accept(@NonNull OutputStream output) throws Exception {
    try (input) {
      copy(input, output);
    }
  }

  @Override
  public void collect(@NonNull HttpServletRequest req, @NonNull HttpServletResponse res) throws Exception {
    res.addHeader("Content-Disposition", "attachment;filename=" + name);
    FILE.super.collect(req, res);
  }

  @NonNull
  @Override
  public String get() {
    return name;
  }

  @Override
  public String toString() {
    return name;
  }
}
