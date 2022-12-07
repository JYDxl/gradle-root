package org.github.core.util;

import java.util.function.Consumer;
import lombok.*;
import io.netty.buffer.ByteBuf;

public abstract class BufUtil {
  public static void beforeRelease(@NonNull ByteBuf buf, @NonNull Consumer<ByteBuf> consumer) {
    try {
      consumer.accept(buf);
    } finally {
      buf.release();
    }
  }
}
