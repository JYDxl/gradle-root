package org.github.web.cache;

import java.util.Map;
import java.util.function.Function;
import javax.annotation.Nullable;
import lombok.*;
import org.github.base.entity.SysMenuEntity;
import org.github.base.service.ISysMenuService;
import org.github.cache.CacheNameSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static com.google.common.collect.ImmutableMap.*;
import static java.lang.Long.*;
import static java.util.Objects.requireNonNull;
import static org.github.web.common.CacheName.*;

@Component
public class SysMenuNameCache extends CustomCache<SysMenuEntity,SysMenuEntity,String> {
  @Autowired
  private ISysMenuService sysMenuService;

  @NonNull @Override public CacheNameSupplier getRegion() {
    return sysMenuName;
  }

  @NonNull @Override public Map<String,SysMenuEntity> get() {
    val query = sysMenuService.lambdaQuery();
    query.select(SysMenuEntity::getMenuId, SysMenuEntity::getName, SysMenuEntity::getEnabled);
    val list = query.list();
    return list.stream().collect(toImmutableMap(Function.<SysMenuEntity>identity().andThen(SysMenuEntity::getMenuId).andThen(Object::toString), Function.identity()));
  }

  @Nullable @Override public SysMenuEntity apply(@NonNull String key) {
    val query = sysMenuService.lambdaQuery();
    query.eq(SysMenuEntity::getMenuId, parseLong(key));
    return query.one();
  }

  @Override
  public @NonNull String getKey(SysMenuEntity entity) {
    return requireNonNull(entity.getMenuId()).toString();
  }

  @Override
  public @Nullable SysMenuEntity getValue(SysMenuEntity entity) {
    return entity;
  }

  @NonNull
  @Override
  public Function<SysMenuEntity, String> getMapper() {
    return SysMenuEntity::getName;
  }
}
