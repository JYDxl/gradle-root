package org.github.common

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthorController {
  @Autowired
  private lateinit var authorInfo: AuthorInfo

  @RequestMapping("/")
  fun index() = "${authorInfo.username} : ${authorInfo.password}"
}
