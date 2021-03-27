package org.github.exception;

public class ParamsErrorException extends RuntimeException {
  public ParamsErrorException() {}

  public ParamsErrorException(String message) {
    super(message);
  }

  public ParamsErrorException(String message, Throwable cause) {
    super(message, cause);
  }

  public ParamsErrorException(Throwable cause) {
    super(cause);
  }

  public ParamsErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
