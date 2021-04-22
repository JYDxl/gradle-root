package org.github.cache;

import java.util.Map;
import java.util.function.Function;
import lombok.*;
import org.github.base.entity.UserEntity;
import org.github.base.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import static java.util.Optional.*;
import static java.util.stream.Collectors.*;

public class UserCache extends AbstractCacheSupplier<UserEntity> {
  @Autowired
  private IUserService userService;

  @Deprecated
  @Override
  public @NonNull Map<String,UserEntity> get() {
    val query = userService.lambdaQuery();
    val list  = query.list();
    return list.stream().collect(toMap(Function.<UserEntity>identity().andThen(UserEntity::getId).andThen(String::valueOf), Function.identity()));
  }

  @Deprecated
  @Override
  public UserEntity apply(@NonNull String key) {
    val query = Wrappers.<UserEntity>lambdaQuery();
    query.eq(UserEntity::getId, key);
    val entity = userService.getOne(query, true);
    return ofNullable(entity).orElse(null);
  }

  @NonNull
  @Override
  public String getRegion() {
    return "user";
  }
}
