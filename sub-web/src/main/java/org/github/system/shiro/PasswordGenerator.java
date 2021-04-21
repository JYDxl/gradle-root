package org.github.system.shiro;

import lombok.*;
import org.apache.shiro.crypto.hash.SimpleHash;

@Data
public class PasswordGenerator {
  @NonNull
  private final String hashAlgorithm;

  private final int hashIterations;

  public PasswordGenerator(@NonNull String hashAlgorithm, int hashIterations) {
    this.hashAlgorithm = hashAlgorithm;
    this.hashIterations = hashIterations;
  }

  public String generator(@NonNull String password, String salt) {
    return new SimpleHash(hashAlgorithm, password, salt, hashIterations).toHex();
  }
}
