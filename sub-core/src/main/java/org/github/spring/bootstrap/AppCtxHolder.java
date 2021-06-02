package org.github.spring.bootstrap;

import lombok.NonNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AppCtxHolder implements ApplicationContextAware {
  @Override
  public void setApplicationContext(@NonNull ApplicationContext context) throws BeansException {
    appCtx = context;
  }

  public static @NonNull ApplicationContext getAppCtx() {
    return appCtx;
  }

  private static ApplicationContext appCtx;
}
