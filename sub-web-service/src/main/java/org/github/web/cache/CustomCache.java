package org.github.web.cache;

import lombok.NonNull;
import net.oschina.j2cache.CacheChannel;
import org.github.cache.AbstractCache;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CustomCache<V> extends AbstractCache<V> implements InitializingBean {
  @Autowired
  private CacheChannel cacheChannel;

  @Override
  public void afterPropertiesSet() throws Exception {
    loadAll();
  }

  @NonNull
  @Override
  public CacheChannel getChannel() {
    return cacheChannel;
  }
}
