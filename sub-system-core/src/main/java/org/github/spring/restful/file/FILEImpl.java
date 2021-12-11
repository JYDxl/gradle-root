package org.github.spring.restful.file;

import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.*;
import com.google.common.net.MediaType;
import static cn.hutool.core.util.URLUtil.*;
import static org.github.util.ObjUtil.*;

@AllArgsConstructor
@Data
class FILEImpl implements FILE {
  private final @NonNull  String      name;
  private final @NonNull  InputStream input;
  private final @Nullable MediaType   type;

  @Override
  public void collect(@NonNull HttpServletRequest req, @NonNull HttpServletResponse res) throws Exception {
    res.addHeader("Content-Disposition", "attachment;filename=" + name);
    FILE.super.collect(req, res);
  }

  @Override
  public void accept(@NonNull OutputStream output) throws Exception {
    try (input) {
      input.transferTo(output);
    }
  }

  @Override
  public @NonNull MediaType mediaType() {
    return firstNonNull(type, FILE.super.mediaType());
  }

  @Override
  public @NonNull String get() {
    return decode(name);
  }

  @Override
  public String toString() {
    return get();
  }
}
