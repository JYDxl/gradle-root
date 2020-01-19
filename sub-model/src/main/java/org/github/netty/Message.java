package org.github.netty;

import org.github.ops.spring.SpringOpsKt;
import lombok.Data;

@Data
public class Message {
  /** header. */
  private Header header;
  /** header. */
  private Object body;

  @Override
  public String toString() {
    return SpringOpsKt.json(this, null);
  }
}
