package org.github.cache;

import lombok.NonNull;
import org.springframework.context.ApplicationEvent;

import static cn.hutool.core.date.LocalDateTimeUtil.of;
import static com.google.common.base.MoreObjects.toStringHelper;

public class CacheEvent<E> extends ApplicationEvent {
  @NonNull
  private final CacheStatus       status;
  @NonNull
  private final CacheNameSupplier name;

  public CacheEvent(@NonNull Object source, @NonNull CacheStatus status, @NonNull CacheNameSupplier name) {
    super(source);
    this.status = status;
    this.name = name;
  }

  @Override
  public String toString() {
    return toStringHelper(this)
      .add("status", status)
      .add("entity", source)
      .add("name", name)
      .add("time", of(getTimestamp()))
      .toString();
  }

  @SuppressWarnings("unchecked")
  public @NonNull E getEntity() {
    return (E) source;
  }

  public @NonNull CacheNameSupplier getName() {
    return name;
  }

  public @NonNull CacheStatus getStatus() {
    return status;
  }
}
