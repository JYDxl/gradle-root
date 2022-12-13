package org.github.blog.mapper

import org.github.blog.bo.BlogPageBo
import org.github.blog.vo.BlogPageVo
import org.github.core.base.IPage
import org.github.core.mybatis.MyBatisMapper

@MyBatisMapper
interface BlogMapper {
  fun page(page: IPage<BlogPageVo>, bo: BlogPageBo): IPage<BlogPageVo>
}
