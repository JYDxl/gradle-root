package org.github.netty;

import java.util.Collections;
import java.util.Map;
import lombok.Data;
import org.github.ops.ObjectOpsKt;

@Data
public class Header {
  /** tag. */
  private int  crcCode = 0XABEF0101;
  /** length. */
  private int  length;
  /** session. */
  private long sessionId;
  /** type. */
  private byte type;
  /** priority. */
  private byte priority;

  private Map<String, Object> attachment = Collections.emptyMap();

  @Override
  public String toString() {
    return ObjectOpsKt.getJson(this);
  }
}
