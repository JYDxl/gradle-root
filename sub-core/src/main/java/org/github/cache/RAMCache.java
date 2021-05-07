package org.github.cache;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import static com.google.common.collect.Maps.*;
import static java.lang.String.*;
import static java.util.Optional.*;

public class RAMCache implements InitializingBean {
  @Autowired
  private List<CacheSupplier<?>> caches;

  private Map<CacheNameSupplier,CacheSupplier<?>> map;

  @Override
  public void afterPropertiesSet() throws Exception {
    map = uniqueIndex(caches, CacheSupplier::getRegion);
  }

  @SuppressWarnings("unchecked")
  public @NonNull <T> CacheSupplier<T> getCache(@NonNull CacheNameSupplier name) {
    return (CacheSupplier<T>) ofNullable(map.get(name)).orElseThrow(() -> new NoSuchElementException(format("缓存实现[%s]不存在", name)));
  }
}
