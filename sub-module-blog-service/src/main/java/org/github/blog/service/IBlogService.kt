package org.github.blog.service

import javax.validation.Valid
import org.github.blog.bo.BlogEditBo
import org.github.blog.bo.BlogPageBo
import org.github.blog.vo.BlogDetailVo
import org.github.blog.vo.BlogPageVo
import org.github.core.spring.restful.json.JSONArrayReturn
import org.github.core.spring.restful.json.JSONDataReturn
import org.github.core.spring.restful.json.JSONPageReturn
import org.github.core.spring.restful.json.JSONReturn
import org.github.mysql.blog.entity.BlogMbpPo

interface IBlogService {
  fun page(@Valid bo: BlogPageBo): JSONPageReturn<BlogPageVo>

  fun detail(id: Long): JSONDataReturn<BlogDetailVo>

  fun edit(@Valid bo: BlogEditBo): JSONReturn

  fun all(): JSONArrayReturn<BlogMbpPo>
}
