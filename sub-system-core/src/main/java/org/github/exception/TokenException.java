package org.github.exception;

import cn.dev33.satoken.exception.SaTokenException;

public class TokenException extends SaTokenException {
  public TokenException(String message) {
    super(message);
  }

  public TokenException(String message, Throwable cause) {
    super(message, cause);
  }

  public TokenException(Throwable cause) {
    super(cause);
  }
}
