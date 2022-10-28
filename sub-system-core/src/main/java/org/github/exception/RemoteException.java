package org.github.exception;

import lombok.*;
import org.github.spring.restful.json.JSONReturn;

public class RemoteException extends RuntimeException {
  private final @NonNull JSONReturn data;

  public RemoteException(@NonNull JSONReturn data) {
    this.data = data;
  }

  public RemoteException(String message, @NonNull JSONReturn data) {
    super(message);
    this.data = data;
  }

  public RemoteException(String message, Throwable cause, @NonNull JSONReturn data) {
    super(message, cause);
    this.data = data;
  }

  public RemoteException(Throwable cause, @NonNull JSONReturn data) {
    super(cause);
    this.data = data;
  }

  public RemoteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, @NonNull JSONReturn data) {
    super(message, cause, enableSuppression, writableStackTrace);
    this.data = data;
  }

  public @NonNull JSONReturn getData() {
    return data;
  }
}
