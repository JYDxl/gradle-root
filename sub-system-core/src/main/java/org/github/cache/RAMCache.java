package org.github.cache;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import static com.google.common.base.MoreObjects.*;
import static com.google.common.collect.Maps.*;
import static java.lang.String.*;
import static java.util.Collections.*;
import static java.util.Optional.*;

public class RAMCache implements InitializingBean, ApplicationListener<CacheEvent> {
  @Autowired(required = false)
  private List<CacheSupplier<?,?>> caches;

  private Map<CacheNameSupplier,CacheSupplier<?,?>> map;

  @Override
  public void afterPropertiesSet() {
    map = uniqueIndex(firstNonNull(caches, emptyList()), CacheSupplier::getName);
  }

  @Override
  public void onApplicationEvent(CacheEvent event) {
    val name  = event.getName();
    val cache = map.get(event.getName());
    if (cache == null) throw throwing(name);
    cache.accept(event);
  }

  private RuntimeException throwing(CacheNameSupplier name) {
    return new NoSuchElementException(format("缓存实现[%s]不存在", name));
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public <R> CacheSupplier<?,R> getCache(@NonNull CacheNameSupplier name) {
    return (CacheSupplier<?,R>) ofNullable(map.get(name)).orElseThrow(() -> throwing(name));
  }
}
