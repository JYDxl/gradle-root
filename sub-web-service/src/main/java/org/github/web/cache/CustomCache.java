package org.github.web.cache;

import org.github.cache.AbstractJ2Cache;
import org.springframework.beans.factory.InitializingBean;

public abstract class CustomCache<E, R> extends AbstractJ2Cache<E,R> implements InitializingBean {
  @Override
  public void afterPropertiesSet() throws Exception {
    load();
  }
}
