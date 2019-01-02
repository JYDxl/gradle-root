package org.github.common.mapper;

import java.time.LocalDateTime;

import org.apache.ibatis.annotations.Select;
import org.jetbrains.annotations.NotNull;

public interface CommonMapper {
  @Select("select now()")
  @NotNull
  LocalDateTime now();
}
