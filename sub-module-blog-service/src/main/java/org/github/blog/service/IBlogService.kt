package org.github.blog.service

import javax.validation.Valid
import org.github.blog.bo.BlogPageBo
import org.github.blog.vo.BlogPageVo
import org.github.core.spring.restful.json.JSONPageReturn

interface IBlogService {
  fun page(@Valid bo: BlogPageBo): JSONPageReturn<BlogPageVo>
}
