package org.github.blog.service.impl

import org.github.blog.bo.BlogPageBo
import org.github.blog.mapper.BlogMapper
import org.github.blog.service.IBlogService
import org.github.blog.vo.BlogPageVo
import org.github.core.spring.restful.json.JSONPageReturn
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated

@Validated
@Service
class BlogService: IBlogService {
  @Autowired
  private lateinit var blogMapper: BlogMapper

  override fun page(bo: BlogPageBo): JSONPageReturn<BlogPageVo> {
    val page = blogMapper.page(bo.page(), bo)
    val data = trans(page.records)
    return JSONPageReturn.of(page, data)
  }

  private fun trans(records: List<BlogPageVo>): List<BlogPageVo> {
    println(records)
    TODO("Not yet implemented")
  }
}
