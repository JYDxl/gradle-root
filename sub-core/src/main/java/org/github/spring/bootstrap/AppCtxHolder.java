package org.github.spring.bootstrap;

import lombok.NonNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AppCtxHolder implements ApplicationContextAware {
    private static ApplicationContext appCtx;

    public static @NonNull ApplicationContext getAppCtx() {
        return appCtx;
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext context) throws BeansException {
        appCtx = context;
    }
}
