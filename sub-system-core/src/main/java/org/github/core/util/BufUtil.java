package org.github.core.util;

import io.netty.buffer.ByteBuf;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public abstract class BufUtil {
  public static void beforeRelease(@NotNull ByteBuf buf, @NotNull Consumer<ByteBuf> consumer) {
    try {
      consumer.accept(buf);
    } finally {
      buf.release();
    }
  }
}
