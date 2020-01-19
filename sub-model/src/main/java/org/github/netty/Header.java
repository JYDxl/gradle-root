package org.github.netty;

import org.github.ops.spring.SpringOpsKt;
import lombok.Data;

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
    return SpringOpsKt.json(this, null);
  }
}
