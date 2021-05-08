package org.github.shiro;

import lombok.*;
import static cn.hutool.core.date.DateUtil.*;
import static com.auth0.jwt.JWT.*;
import static com.auth0.jwt.algorithms.Algorithm.*;
import static java.time.LocalDateTime.now;

public class JWTUtil {
  public static void verify(@NonNull String token, @NonNull String username, @NonNull String secret) {
    val algorithm = HMAC256(secret);
    val verifier  = require(algorithm).withClaim("username", username).build();
    verifier.verify(token);
  }

  public static @NonNull String getUsername(@NonNull String token) {
    val jwt = decode(token);
    return jwt.getClaim("username").asString();
  }

  public static @NonNull String sign(@NonNull String username, @NonNull String secret) {
    val date      = date(now().plusMinutes(EXPIRE_MIN)).toJdkDate();
    val algorithm = HMAC256(secret);
    return create().withClaim("username", username).withExpiresAt(date).sign(algorithm);
  }

  private static final long EXPIRE_MIN = 30;
}
