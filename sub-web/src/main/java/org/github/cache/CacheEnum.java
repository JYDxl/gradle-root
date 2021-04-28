package org.github.cache;

import java.util.function.Supplier;

public enum CacheEnum implements Supplier<String> {
    user,
    username;

    @Override
    public String get() {
        return toString();
    }
}
