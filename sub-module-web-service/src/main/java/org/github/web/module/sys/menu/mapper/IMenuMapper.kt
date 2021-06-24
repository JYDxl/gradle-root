package org.github.web.module.sys.menu.mapper

import org.github.base.IPage
import org.github.mybatis.MyBatisMapper
import org.github.web.module.sys.menu.model.vo.QueryMenuListVO
import org.github.web.module.sys.menu.model.bo.QueryMenuListBO

@MyBatisMapper
interface IMenuMapper {
  fun queryPage(page: IPage<QueryMenuListVO>, bo: QueryMenuListBO): IPage<QueryMenuListVO>
}
