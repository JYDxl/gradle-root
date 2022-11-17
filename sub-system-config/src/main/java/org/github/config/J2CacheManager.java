package org.github.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import net.oschina.j2cache.J2CacheBuilder;
import net.oschina.j2cache.J2CacheConfig;
import net.oschina.j2cache.springcache.J2CacheSpringCacheManageAdapter;

public class J2CacheManager extends CachingConfigurerSupport {
  @Autowired
  private J2CacheConfig  j2CacheConfig;
  @Autowired
  private J2CacheBuilder j2CacheBuilder;

  @Override
  public CacheManager cacheManager() {
    return new J2CacheSpringCacheManageAdapter(j2CacheBuilder, j2CacheConfig.isDefaultCacheNullObject());
  }
}
