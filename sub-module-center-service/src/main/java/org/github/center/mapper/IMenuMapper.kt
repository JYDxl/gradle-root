package org.github.center.mapper

import org.apache.ibatis.annotations.Param
import org.github.base.IPage
import org.github.center.vo.QueryMenuListVO
import org.github.mybatis.MyBatisMapper

@MyBatisMapper
interface IMenuMapper {
  fun queryPage(@Param("page") page: IPage<QueryMenuListVO>, @Param("bo") bo: org.github.center.bo.QueryMenuListBO): IPage<QueryMenuListVO>
}
