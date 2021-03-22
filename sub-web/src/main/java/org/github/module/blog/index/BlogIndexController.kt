package org.github.module.blog.index

import org.github.base.service.IUsersService
import org.github.spring.restful.json.JSONDataReturn
import org.github.spring.restful.view.VIEW
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class BlogIndexController {
  @Autowired
  private lateinit var usersService: IUsersService

  @GetMapping("/")
  fun index() = VIEW.of("index")

  @GetMapping("/hello")
  fun hello() = JSONDataReturn.of(usersService.getById("2333"))
}
