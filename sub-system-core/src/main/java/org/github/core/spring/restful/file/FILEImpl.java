package org.github.core.spring.restful.file;

import cn.hutool.extra.servlet.ServletUtil;
import com.google.common.base.MoreObjects;
import com.google.common.net.MediaType;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Data
class FILEImpl implements FILE {
  private final @NonNull  String      name;
  private final @NonNull  InputStream input;
  private final @Nullable MediaType   type;

  @Override
  public void handle(@NonNull HttpServletRequest req, @NonNull HttpServletResponse res) {
    ServletUtil.write(res, input, mediaType().toString(), name);
  }

  @Override
  @NonNull
  public String get() {
    return name;
  }

  @Override
  @NonNull
  public MediaType mediaType() {
    return MoreObjects.firstNonNull(type, FILE.super.mediaType());
  }

  @Override
  public String toString() {
    return get();
  }
}
