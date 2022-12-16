package org.github.core.spring.restful.file;

import com.google.common.net.MediaType;
import java.io.InputStream;
import org.jetbrains.annotations.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import static cn.hutool.extra.servlet.ServletUtil.write;
import static com.google.common.base.MoreObjects.firstNonNull;

@AllArgsConstructor
@Data
class FILEImpl implements FILE {
  @NotNull
  private final String      name;
  @NotNull
  private final InputStream input;
  @Nullable
  private final MediaType   type;

  @Override
  public void handle(@NotNull HttpServletRequest req, @NotNull HttpServletResponse res) {
    write(res, input, mediaType().toString(), name);
  }

  @Override
  @NotNull
  public String get() {
    return name;
  }

  @Override
  @NotNull
  public MediaType mediaType() {
    return firstNonNull(type, FILE.super.mediaType());
  }

  @Override
  public String toString() {
    return get();
  }
}
