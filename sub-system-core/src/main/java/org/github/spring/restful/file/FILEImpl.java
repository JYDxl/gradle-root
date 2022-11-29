package org.github.spring.restful.file;

import java.io.InputStream;
import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.*;
import com.google.common.net.MediaType;
import static cn.hutool.extra.servlet.ServletUtil.*;
import static com.google.common.base.MoreObjects.*;

@AllArgsConstructor
@Data
class FILEImpl implements FILE {
  private final @NonNull  String      name;
  private final @NonNull  InputStream input;
  private final @Nullable MediaType   type;

  @Override
  public void collect(@NonNull HttpServletRequest req, @NonNull HttpServletResponse res) throws Exception {
    write(res, input, mediaType().toString(), name);
  }

  @Override
  @NonNull
  public String get() {
    return name;
  }

  @Override
  @NonNull
  public MediaType mediaType() {
    return firstNonNull(type, FILE.super.mediaType());
  }

  @Override
  public String toString() {
    return get();
  }
}
