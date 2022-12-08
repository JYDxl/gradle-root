package org.github.common.service.impl;

import org.github.common.service.ICommonService;
import org.github.core.base.CodeType;
import org.github.core.cache.EnumCache;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Function;

import static cn.hutool.core.bean.BeanUtil.*;
import static cn.hutool.core.text.CharSequenceUtil.toCamelCase;
import static java.util.stream.Collectors.toList;

@Service
public class CommonService implements ICommonService {
  @Resource
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
    String from = type.underLine() ? toCamelCase(type.field()) : type.field();
    Object code = getFieldValue(obj, from);
    if (code == null) return;
    Object name = enumCache.get(type.type(), code);
    if (name == null) return;
    setFieldValue(obj, field.getName(), name);
  }
}
