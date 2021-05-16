package org.github.web.cache;

import org.github.cache.AbstractJ2Cache;
import org.springframework.beans.factory.InitializingBean;

public abstract class CustomCache<V, E, R> extends AbstractJ2Cache<V, E, R> implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        loadAll();
    }
}
