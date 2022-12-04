package org.github.service.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Function;
import org.github.base.CodeType;
import org.github.cache.EnumCache;
import org.github.service.ICommonService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static cn.hutool.core.bean.BeanUtil.*;
import static java.util.stream.Collectors.*;

@Service
public class CommonService implements ICommonService {
  @Autowired
  private EnumCache enumCache;

  @NotNull
  @Override
  public <T, R> List<R> transCode(@NotNull List<? extends T> list, @NotNull Class<R> clazz, @NotNull Function<T,R> func) {
    return list.stream().map(func).peek(this::transCode).collect(toList());
  }

  private <R> void transCode(R obj) {
    edit(obj, field -> {
      transCode(obj, field);
      return field;
    });
  }

  private <R> void transCode(R obj, Field field) {
    CodeType type = field.getAnnotation(CodeType.class);
    if (type == null) return;
    Object code = getFieldValue(obj, type.field());
    if (code == null) return;
    Object name = enumCache.get(type.type(), code);
    if (name == null) return;
    setFieldValue(obj, field.getName(), name);
  }
}
