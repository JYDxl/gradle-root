package org.github.cache;

import java.util.Map;
import lombok.*;
import org.github.base.entity.UserEntity;
import org.github.base.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import static com.baomidou.mybatisplus.core.toolkit.Wrappers.*;
import static com.google.common.collect.ImmutableMap.*;
import static java.util.function.Function.*;

public class UserCache extends AbstractCacheSupplier<UserEntity> {
  @Autowired
  private IUserService userService;

  @Deprecated
  @Override
  public @NonNull Map<String,UserEntity> get() {
    val query = userService.lambdaQuery();
    val list  = query.list();
    return list.stream().collect(toImmutableMap(v -> v.getId().toString(), identity()));
  }

  @Deprecated
  @Override
  public UserEntity apply(@NonNull String key) {
    val query = lambdaQuery(UserEntity.class);
    query.eq(UserEntity::getId, key);
    return userService.getOne(query, true);
  }

  @NonNull
  @Override
  public String getRegion() {
    return "user";
  }
}
