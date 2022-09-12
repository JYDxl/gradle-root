package org.github.web.module.sys.menu.mapper

import org.apache.ibatis.annotations.Param
import org.github.base.IPage
import org.github.mybatis.MyBatisMapper
import org.github.web.module.sys.menu.dto.QueryMenuListVO
import org.github.web.module.sys.menu.dto.QueryMenuListBO

@MyBatisMapper
interface IMenuMapper {
  fun queryPage(@Param("page") page: IPage<QueryMenuListVO>, @Param("bo") bo: QueryMenuListBO): IPage<QueryMenuListVO>
}
