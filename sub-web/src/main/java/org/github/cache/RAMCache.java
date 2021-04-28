package org.github.cache;

import lombok.NonNull;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.function.Supplier;

import static com.google.common.collect.Maps.uniqueIndex;
import static java.lang.String.format;
import static java.util.Optional.ofNullable;

public class RAMCache implements InitializingBean {
    @Autowired
    private List<CacheSupplier<?>> caches;

    private Map<Supplier<String>, CacheSupplier<?>> map;

    @Override
    public void afterPropertiesSet() throws Exception {
        map = uniqueIndex(caches, CacheSupplier::getRegion);
    }

    @SuppressWarnings("unchecked")
    public @NonNull <T> CacheSupplier<T> getCache(@NonNull CacheEnum name) {
        return (CacheSupplier<T>) ofNullable(map.get(name)).orElseThrow(() -> new NoSuchElementException(format("缓存实现[%s]不存在", name.toString())));
    }
}
