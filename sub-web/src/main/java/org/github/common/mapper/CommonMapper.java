package org.github.common.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Select;

public interface CommonMapper {
  @Select("select now()")
  Date getNow();
}
