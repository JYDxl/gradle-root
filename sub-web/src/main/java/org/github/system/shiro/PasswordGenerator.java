package org.github.system.shiro;

import lombok.*;
import org.apache.shiro.crypto.hash.SimpleHash;

import javax.annotation.Nullable;

@Data
public class PasswordGenerator {
  private final @NonNull String hashAlgorithm;

  private final int hashIterations;

  public PasswordGenerator(@NonNull String hashAlgorithm, int hashIterations) {
    this.hashAlgorithm = hashAlgorithm;
    this.hashIterations = hashIterations;
  }

  public @NonNull String generate(@NonNull String password, @Nullable Object salt) {
    return new SimpleHash(hashAlgorithm, password, salt, hashIterations).toHex();
  }
}
