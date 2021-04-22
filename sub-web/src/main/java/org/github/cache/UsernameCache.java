package org.github.cache;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.NonNull;
import lombok.val;
import org.github.base.entity.UsersEntity;
import org.github.base.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static java.util.Collections.emptyMap;
import static java.util.Optional.ofNullable;

@Component
public class UsernameCache extends AbstractCacheSupplier<String> {
    @Autowired
    private IUsersService usersService;

    @NonNull
    @Override
    public String getRegion() {
        return "username";
    }

    @Deprecated
    @Override
    public String apply(@NonNull String key) {
        val query = Wrappers.<UsersEntity>lambdaQuery();
        query.eq(UsersEntity::getId, key).select(UsersEntity::getUsername);
        val entity = usersService.getOne(query, true);
        return ofNullable(entity).map(UsersEntity::getUsername).orElse(null);
    }

    @Deprecated
    @Override
    public @NonNull Map<String, String> get() {
//        val query = usersService.lambdaQuery();
//        query.select(UsersEntity::getId, UsersEntity::getUsername);
//        val list = query.list();
//        return list.stream().collect(toMap(UsersEntity::getId, UsersEntity::getUsername));
        return emptyMap();
    }
}
