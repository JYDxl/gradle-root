package org.github.core.spring.restful.file;

import com.google.common.net.MediaType;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import static cn.hutool.extra.servlet.ServletUtil.write;
import static com.google.common.base.MoreObjects.firstNonNull;

@AllArgsConstructor
@Data
class FILEImpl implements FILE {
  @NonNull
  private final String      name;
  @NonNull
  private final InputStream input;
  @Nullable
  private final MediaType   type;

  @Override
  public void handle(@NonNull HttpServletRequest req, @NonNull HttpServletResponse res) {
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
