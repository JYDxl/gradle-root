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
import org.github.core.spring.restful.json.JSONArray
import org.github.core.spring.restful.json.JSONBase
import org.github.core.spring.restful.json.JSONData
import org.github.core.spring.restful.json.JSONPage
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

  override fun page(bo: BlogPageBo): JSONPage<BlogPageVo> {
    val page = blogMapper.page(bo.page(), bo)
    val data = transPage(page.records)
    return JSONPage.of(page, data)
  }

  override fun detail(id: Long): JSONData<BlogDetailVo> {
    val po = blogMbpService.getById(id) ?: throw ClientException("记录不存在")
    val vo = transDetail(po)
    return JSONData.of(vo)
  }

  override fun edit(bo: BlogEditBo): JSONBase {
    blogMbpService.saveOrUpdate(bo)
    return JSONBase.ok()
  }

  override fun all(): JSONArray<BlogMbpPo> {
    val list: MutableList<BlogMbpPo> = blogMbpService.list()
    return JSONArray.of(list)
  }

  override fun remove(id: Long): JSONBase {
    blogMbpService.removeById(id)
    return JSONBase.ok()
  }

  private fun transDetail(po: BlogMbpPo): BlogDetailVo {
    return commonService.trans(singletonList(po), BlogDetailVo::class.java).first()
  }

  private fun transPage(records: List<BlogPageVo>): List<BlogPageVo> {
    return commonService.trans(records, BlogPageVo::class.java, identity())
  }
}
