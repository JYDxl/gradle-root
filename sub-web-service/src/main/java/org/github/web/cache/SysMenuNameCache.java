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
import static java.util.Optional.ofNullable;
import static org.github.web.common.CacheName.*;
import static org.github.web.enums.Enable.*;

@Component
public class SysMenuNameCache extends CustomCache<String,SysMenuEntity> {
  @Autowired
  private ISysMenuService sysMenuService;

  @NonNull @Override public CacheNameSupplier getRegion() {
    return sysMenuName;
  }

  @NonNull @Override public Map<String,String> get() {
    val query = sysMenuService.lambdaQuery();
    query.eq(SysMenuEntity::getEnabled, enabled.getCode());
    val list = query.list();
    return list.stream().collect(toImmutableMap(Function.<SysMenuEntity>identity().andThen(SysMenuEntity::getMenuId).andThen(Object::toString), SysMenuEntity::getName));
  }

  @Nullable @Override public String apply(@NonNull String key) {
    val query = sysMenuService.lambdaQuery();
    query.eq(SysMenuEntity::getMenuId, parseLong(key));
    val entity = query.oneOpt();
    return entity.map(SysMenuEntity::getName).orElse(null);
  }

  @Override
  public @NonNull String getKey(SysMenuEntity entity) {
    return requireNonNull(entity.getMenuId()).toString();
  }

  @Override
  public @Nullable String getValue(SysMenuEntity entity) {
    return ofNullable(entity).filter(v -> enabled.getCode().equals(v.getEnabled())).map(SysMenuEntity::getName).orElse(null);
  }
}
