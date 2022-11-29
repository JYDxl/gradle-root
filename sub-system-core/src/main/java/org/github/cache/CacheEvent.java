package org.github.cache;

import java.util.Collection;
import lombok.*;
import org.springframework.context.ApplicationEvent;
import static cn.hutool.core.date.LocalDateTimeUtil.*;
import static com.google.common.base.MoreObjects.*;

public class CacheEvent extends ApplicationEvent {
  private final @NonNull CacheStatus       status;
  private final @NonNull CacheNameSupplier name;

  public CacheEvent(@NonNull String id, @NonNull CacheStatus status, @NonNull CacheNameSupplier name) {
    super(id);
    this.status = status;
    this.name   = name;
  }

  public CacheEvent(@NonNull Collection<String> id, @NonNull CacheStatus status, @NonNull CacheNameSupplier name) {
    super(id);
    this.status = status;
    this.name   = name;
  }

  @Override
  public String toString() {
    return toStringHelper(this)
      .add("status", status)
      .add("id", source)
      .add("name", name)
      .add("time", of(getTimestamp()))
      .toString();
  }

  @NonNull
  public CacheNameSupplier getName() {
    return name;
  }

  @NonNull
  public CacheStatus getStatus() {
    return status;
  }
}
