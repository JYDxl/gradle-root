package org.github.common.mapper;

import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import org.apache.ibatis.annotations.Select;

public interface CommonMapper {
  @Select("select now()")
  @Nonnull
  LocalDateTime now();
}
