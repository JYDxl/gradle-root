package org.github.blog.service.impl

import java.util.Collections.singletonList
import java.util.function.Function.identity
import javax.annotation.Resource
import org.github.blog.bo.BlogEditBo
import org.github.blog.bo.BlogPageBo
import org.github.blog.mapper.BlogMapper
import org.github.blog.service.IBlogService
import org.github.blog.vo.BlogDetailVo
import org.github.blog.vo.BlogPageVo
import org.github.common.service.ICommonService
import org.github.core.exception.ClientException
import org.github.core.spring.restful.json.JSONArrayReturn
import org.github.core.spring.restful.json.JSONDataReturn
import org.github.core.spring.restful.json.JSONPageReturn
import org.github.core.spring.restful.json.JSONReturn
import org.github.mysql.blog.entity.BlogMbpPo
import org.github.mysql.blog.service.IBlogMbpService
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated

@Validated
@Service
class BlogService: IBlogService {
  @Resource
  private lateinit var blogMapper: BlogMapper

  @Resource
  private lateinit var commonService: ICommonService

  @Resource
  private lateinit var blogMbpService: IBlogMbpService

  override fun page(bo: BlogPageBo): JSONPageReturn<BlogPageVo> {
    val page = blogMapper.page(bo.page(), bo)
    val data = transPage(page.records)
    return JSONPageReturn.of(page, data)
  }

  override fun detail(id: Long): JSONDataReturn<BlogDetailVo> {
    val po = blogMbpService.getById(id) ?: throw ClientException("记录不存在")
    val vo = transDetail(po)
    return JSONDataReturn.of(vo)
  }

  override fun edit(bo: BlogEditBo): JSONReturn {
    blogMbpService.updateById(bo)
    return JSONReturn.ok()
  }

  override fun all(): JSONArrayReturn<BlogMbpPo> {
    val list: MutableList<BlogMbpPo> = blogMbpService.list()
    return JSONArrayReturn.of(list)
  }

  private fun transDetail(po: BlogMbpPo): BlogDetailVo {
    return commonService.transCode(singletonList(po), BlogDetailVo::class.java).first()
  }

  private fun transPage(records: List<BlogPageVo>): List<BlogPageVo> {
    return commonService.transCode(records, BlogPageVo::class.java, identity())
  }
}
