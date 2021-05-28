package org.github.web.cache;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import lombok.*;
import org.github.cache.CacheNameSupplier;
import org.github.mysql.web.base.entity.SysMenuMbpEntity;
import org.github.mysql.web.base.service.ISysMenuMbpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static com.google.common.collect.ImmutableList.*;
import static com.google.common.collect.ImmutableMap.*;
import static java.util.function.Function.identity;
import static org.github.mysql.web.base.enums.Enable.*;
import static org.github.web.common.CacheName.*;

@Component
public class SysMenuNameJ2Cache extends CustomJ2Cache<SysMenuMbpEntity,String> {
  @Autowired
  private ISysMenuMbpService sysMenuMbpService;

  @Override
  public @NonNull CacheNameSupplier getName() {
    return sysMenuName;
  }

  @Override
  public @NonNull Function<SysMenuMbpEntity,String> getMapper() {
    return SysMenuMbpEntity::getName;
  }

  @Override
  public @NonNull Predicate<SysMenuMbpEntity> getFilter() {
    return v -> v != null && enabled.getCode().equals(v.getEnabled());
  }

  @Override
  public @NonNull Map<String,SysMenuMbpEntity> load(@NonNull Collection<String> keys) {
    val query = sysMenuMbpService.lambdaQuery();
    query.in(!keys.isEmpty(), SysMenuMbpEntity::getMenuId, keys.stream().map(Long::parseLong).collect(toImmutableList()));
    query.select(SysMenuMbpEntity::getMenuId, SysMenuMbpEntity::getName, SysMenuMbpEntity::getEnabled);
    val list = query.list();
    return list.stream().collect(toImmutableMap(v -> v.getMenuId().toString(), identity()));
  }
}
