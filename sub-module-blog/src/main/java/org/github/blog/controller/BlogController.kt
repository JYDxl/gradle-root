package org.github.blog.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import javax.annotation.Resource
import org.github.blog.bo.BlogEditBo
import org.github.blog.bo.BlogPageBo
import org.github.blog.service.IBlogService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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
  fun page(@RequestBody bo: BlogPageBo) = blogService.page(bo.apply {trim()})

  @ApiOperation("博客相关-详情")
  @GetMapping("detail/{id}")
  fun detail(@PathVariable id: Long) = blogService.detail(id)

  @ApiOperation("博客相关-删除")
  @PostMapping("remove/{id}")
  fun remove(@PathVariable id: Long) = blogService.remove(id)

  @ApiOperation("博客相关-编辑")
  @PostMapping("edit")
  fun edit(@RequestBody bo: BlogEditBo) = blogService.edit(bo.apply {trim()})

  @ApiOperation("博客相关-所有")
  @PostMapping("all")
  fun all() = blogService.all()
}
