package org.github.shiro;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.util.ByteSource;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;

import static org.apache.shiro.codec.CodecSupport.toBytes;

public class CustomByteSource implements ByteSource, Serializable {
  private byte[] bytes;
  private String cachedHex;
  private String cachedBase64;

  public CustomByteSource(Object salt) {
    if (salt != null) {
      if (salt instanceof byte[]) {
        this.bytes = (byte[]) salt;
      } else if (salt instanceof String) {
        this.bytes = toBytes((String) salt);
      } else if (salt instanceof ByteSource) {
        this.bytes = ((ByteSource) salt).getBytes();
      }
    }
  }

  public CustomByteSource() {
  }

  public int hashCode() {
    return this.bytes != null && this.bytes.length != 0 ? Arrays.hashCode(this.bytes) : 0;
  }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    } else if (o instanceof ByteSource) {
      ByteSource bs = (ByteSource) o;
      return Arrays.equals(this.getBytes(), bs.getBytes());
    } else {
      return false;
    }
  }

  public byte[] getBytes() {
    return this.bytes;
  }

  public String toHex() {
    if (this.cachedHex == null) {
      this.cachedHex = Hex.encodeToString(this.getBytes());
    }

    return this.cachedHex;
  }

  public String toBase64() {
    if (this.cachedBase64 == null) {
      this.cachedBase64 = Base64.encodeToString(this.getBytes());
    }

    return this.cachedBase64;
  }

  public boolean isEmpty() {
    return this.bytes == null || this.bytes.length == 0;
  }

  public String toString() {
    return this.toBase64();
  }

  public static boolean isCompatible(Object o) {
    return o instanceof byte[] || o instanceof char[] || o instanceof String || o instanceof ByteSource || o instanceof File || o instanceof InputStream;
  }
}
