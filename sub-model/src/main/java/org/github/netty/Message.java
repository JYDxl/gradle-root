package org.github.netty;

import lombok.Data;
import org.github.ops.ObjectOpsKt;

@Data
public class Message {
  /** header. */
  private Header header;
  /** header. */
  private Object body;

  @Override
  public String toString() {
    return ObjectOpsKt.json(this, null);
  }
}
