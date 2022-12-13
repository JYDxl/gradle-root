package org.github.blog.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import javax.annotation.Resource
import org.github.blog.bo.BlogPageBo
import org.github.blog.service.IBlogService
import org.github.core.spring.restful.Returnable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api("博客相关")
@RequestMapping("/index/")
@RestController
class BlogController {
  @Resource
  private lateinit var blogService: IBlogService

  @ApiOperation("博客相关-分页")
  @PostMapping("page")
  fun page(@RequestBody bo: BlogPageBo): Returnable {
    return blogService.page(bo)
  }
}
