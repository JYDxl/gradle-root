package org.github.netty;

import lombok.Data;
import org.github.ops.ObjectOpsKt;

@Data
public class Header {
  /** tag. */
  private int    crcCode = 0XABEF0101;
  /** length. */
  private int    length;
  /** session. */
  private long   sessionId;
  /** type. */
  private byte   type;
  /** priority. */
  private byte   priority;
  /** attachment. */
  private String attachment;

  @Override
  public String toString() {
    return ObjectOpsKt.json(this, null);
  }
}
