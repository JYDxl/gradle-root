package org.github.util;

import lombok.extern.slf4j.*;
import lombok.*;
import org.junit.jupiter.api.Test;
import static io.netty.buffer.ByteBufUtil.*;
import static io.netty.buffer.Unpooled.*;
import static org.github.util.BufUtil.*;

@Slf4j
class BufUtilTest {
  @Test
  void beforeReleaseTest() {
    val buf = wrappedBuffer(new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
    log.info(buf.toString());
    beforeRelease(buf, byteBuf -> log.info(hexDump(byteBuf).toUpperCase()));
    log.info(buf.toString());
  }
}
