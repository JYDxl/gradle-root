package org.github.system.shiro;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.NonNull;
import lombok.val;

import static cn.hutool.core.date.DateUtil.date;
import static com.auth0.jwt.JWT.*;
import static com.auth0.jwt.algorithms.Algorithm.HMAC256;
import static java.time.LocalDateTime.now;

public class JWTUtil {
  public static void verify(@NonNull String token, @NonNull String username, @NonNull String secret) {
    Algorithm   algorithm = HMAC256(secret);
    JWTVerifier verifier  = require(algorithm).withClaim("username", username).build();
    verifier.verify(token);
  }

  public static @NonNull String username(@NonNull String token) {
    DecodedJWT jwt = decode(token);
    return jwt.getClaim("username").asString();
  }

  public static @NonNull String sign(@NonNull String username, @NonNull String secret) {
    val       date      = date(now().plusMinutes(EXPIRE_MIN)).toJdkDate();
    Algorithm algorithm = HMAC256(secret);
    return create().withClaim("username", username).withExpiresAt(date).sign(algorithm);
  }

  private static final long EXPIRE_MIN = 30;
}
