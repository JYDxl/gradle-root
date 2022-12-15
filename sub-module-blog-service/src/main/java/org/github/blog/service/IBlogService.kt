package org.github.blog.service

import javax.validation.Valid
import org.github.blog.bo.BlogEditBo
import org.github.blog.bo.BlogPageBo
import org.github.blog.vo.BlogDetailVo
import org.github.blog.vo.BlogPageVo
import org.github.core.spring.restful.json.JSONArray
import org.github.core.spring.restful.json.JSONBase
import org.github.core.spring.restful.json.JSONData
import org.github.core.spring.restful.json.JSONPage
import org.github.mysql.blog.entity.BlogMbpPo

interface IBlogService {
  fun page(@Valid bo: BlogPageBo): JSONPage<BlogPageVo>

  fun detail(id: Long): JSONData<BlogDetailVo>

  fun edit(@Valid bo: BlogEditBo): JSONBase

  fun all(): JSONArray<BlogMbpPo>
}
