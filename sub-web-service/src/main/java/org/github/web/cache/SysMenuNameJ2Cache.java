package org.github.web.cache;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import lombok.*;
import org.github.base.entity.SysMenuEntity;
import org.github.base.service.ISysMenuService;
import org.github.cache.CacheNameSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static com.google.common.collect.ImmutableMap.*;
import static java.lang.Long.*;
import static org.github.web.common.CacheName.*;
import static org.github.web.enums.Enable.*;

@Component
public class SysMenuNameJ2Cache extends CustomJ2Cache<SysMenuEntity,String> {
  @Autowired
  private ISysMenuService sysMenuService;

  @Override
  public @Nullable SysMenuEntity apply(@NonNull String key) {
    val query = sysMenuService.lambdaQuery();
    query.eq(SysMenuEntity::getMenuId, parseLong(key));
    return query.one();
  }

  @Override
  public @NonNull CacheNameSupplier getName() {
    return sysMenuName;
  }

  @Override
  public @NonNull Predicate<SysMenuEntity> getFilter() {
    return v -> v != null && enabled.getCode().equals(v.getEnabled());
  }

  @Override
  public @NonNull Function<SysMenuEntity,String> getMapper() {
    return SysMenuEntity::getName;
  }

  @Override
  public @NonNull Map<String, SysMenuEntity> load(@NonNull Collection<String> keys) {
    val query = sysMenuService.lambdaQuery();
    query.select(SysMenuEntity::getMenuId, SysMenuEntity::getName, SysMenuEntity::getEnabled);
    query.in(!keys.isEmpty(), SysMenuEntity::getMenuId, keys);
    val list = query.list();
    return list.stream().collect(toImmutableMap(v -> v.pkVal().toString(), Function.identity()));
  }
}
