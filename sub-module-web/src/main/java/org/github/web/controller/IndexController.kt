package org.github.web.controller

import org.github.web.Views.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/index/")
class IndexController {
  @GetMapping
  fun index() = INDEX

  @GetMapping("index_v1.html")
  fun indexV1() = INDEX_V1
}
