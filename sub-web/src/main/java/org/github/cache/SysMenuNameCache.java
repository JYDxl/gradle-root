package org.github.cache;

import java.util.Map;
import java.util.function.Function;
import javax.annotation.Nullable;
import lombok.*;
import org.github.base.entity.SysMenuEntity;
import org.github.base.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static com.google.common.collect.ImmutableMap.*;
import static java.lang.Long.*;
import static org.github.web.common.CacheNameEnum.*;

@Component
public class SysMenuNameCache extends AbstractCache<String> {
  @Autowired
  private ISysMenuService sysMenuService;

  @NonNull @Override public CacheNameSupplier getRegion() {
    return sysMenuName;
  }

  @NonNull @Override public Map<String,String> get() {
    val query = sysMenuService.lambdaQuery();
    val list  = query.list();
    return list.stream().collect(toImmutableMap(Function.<SysMenuEntity>identity().andThen(SysMenuEntity::getMenuId).andThen(Object::toString), SysMenuEntity::getName));
  }

  @Nullable @Override public String apply(@NonNull String key) {
    val query = sysMenuService.lambdaQuery();
    query.eq(SysMenuEntity::getMenuId, parseLong(key));
    val entity = query.oneOpt();
    return entity.map(SysMenuEntity::getName).orElse(null);
  }
}
