package org.github.cache;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import static com.google.common.collect.Maps.*;
import static java.lang.String.*;
import static java.util.Optional.*;

@SuppressWarnings("rawtypes")
public class RAMCache implements InitializingBean, ApplicationListener<CacheEvent> {
  @Autowired
  private List<CacheSupplier<?,?,?>> caches;

  private Map<CacheNameSupplier,CacheSupplier<?,?,?>> map;

  @Override
  public void afterPropertiesSet() throws Exception {
    map = uniqueIndex(caches, CacheSupplier::getRegion);
  }

  @SuppressWarnings("unchecked")
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
  public @NonNull <T> CacheSupplier<T,?,?> getCache(@NonNull CacheNameSupplier name) {
    return (CacheSupplier<T,?,?>) ofNullable(map.get(name)).orElseThrow(() -> throwing(name));
  }
}
