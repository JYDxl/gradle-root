package org.github.cache;

import java.util.Map;
import java.util.function.Function;
import lombok.*;
import org.github.base.entity.UserEntity;
import org.github.base.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import static com.baomidou.mybatisplus.core.toolkit.Wrappers.*;
import static com.google.common.collect.ImmutableMap.*;
import static org.github.base.enums.EnableEnum.*;
import static org.github.cache.CacheEnum.*;

public class UserCache extends AbstractCache<UserEntity> {
  @Autowired
  private IUserService userService;

  @NonNull
  @Override
  public CacheNameSupplier getRegion() {
    return user;
  }

  @Deprecated
  @Override
  public @NonNull Map<String,UserEntity> get() {
    val query = userService.lambdaQuery();
    query.eq(UserEntity::getEnabled, enabled.getCode());
    val list = query.list();
    return list.stream().collect(toImmutableMap(v -> String.valueOf(v.getId()), Function.identity()));
  }

  @Deprecated
  @Override
  public UserEntity apply(@NonNull String key) {
    val query = lambdaQuery(UserEntity.class);
    query.eq(UserEntity::getId, key);
    return userService.getOne(query, true);
  }
}
