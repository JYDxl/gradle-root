package org.github.common.service.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Resource;
import lombok.val;
import org.github.common.service.ICommonService;
import org.github.core.base.CodeType;
import org.github.core.cache.EnumCache;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import static cn.hutool.core.bean.BeanUtil.edit;
import static cn.hutool.core.bean.BeanUtil.getFieldValue;
import static cn.hutool.core.bean.BeanUtil.setFieldValue;
import static cn.hutool.core.collection.IterUtil.getFirst;
import static cn.hutool.core.text.CharSequenceUtil.toCamelCase;
import static com.google.common.collect.Lists.transform;
import static java.util.Collections.singletonList;

@Service
public class CommonService implements ICommonService {
  @Resource
  private EnumCache enumCache;

  private <R> R transCode(R obj) {
    edit(obj, field -> {
      transCode(obj, field);
      return field;
    });
    return obj;
  }

  private <R> void transCode(R obj, Field field) {
    val type = field.getAnnotation(CodeType.class);
    if (type == null) return;
    val from = type.underLine() ? toCamelCase(type.field()) : type.field();
    val code = getFieldValue(obj, from);
    if (code == null) return;
    val name = enumCache.get(type.type(), code);
    if (name == null) return;
    setFieldValue(obj, field.getName(), name);
  }

  @NotNull
  @Override
  public <T, R> List<R> trans(@NotNull List<? extends T> list, @NotNull Class<R> clazz, @NotNull Function<T,R> func) {
    return transform(list, func.andThen(this::transCode)::apply);
  }

  @Override
  public <T, R> R trans(T obj, @NotNull Class<R> clazz, @NotNull Function<T,R> func) {
    return getFirst(trans(singletonList(obj), clazz, func));
  }
}
