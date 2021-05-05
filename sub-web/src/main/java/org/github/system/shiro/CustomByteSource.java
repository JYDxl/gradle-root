package org.github.system.shiro;

import java.io.Serializable;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;

public class CustomByteSource extends SimpleByteSource implements Serializable {
  public CustomByteSource(ByteSource source) {
    super(source);
  }
}
