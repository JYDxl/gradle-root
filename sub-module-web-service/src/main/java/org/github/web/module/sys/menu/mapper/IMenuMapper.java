package org.github.web.module.sys.menu.mapper;

import lombok.*;
import org.github.base.IPage;
import org.github.mybatis.MyBatisMapper;
import org.github.web.module.sys.menu.dto.QueryMenuListBO;
import org.github.web.module.sys.menu.dto.QueryMenuListVO;
import org.apache.ibatis.annotations.Param;

@MyBatisMapper
public interface IMenuMapper {
  @NonNull IPage<QueryMenuListVO> queryPage(@Param("page") IPage<QueryMenuListVO> page, @Param("bo") QueryMenuListBO bo);
}
