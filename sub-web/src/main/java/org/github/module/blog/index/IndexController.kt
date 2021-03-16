package org.github.module.blog.index

import org.github.spring.restful.view.VIEW
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {
  @GetMapping("/")
  fun index() = VIEW.of("index")
}
