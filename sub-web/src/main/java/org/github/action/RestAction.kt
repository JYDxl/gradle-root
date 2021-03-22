package org.github.action

import org.github.spring.restful.Returnable
import org.github.spring.restful.json.JSON
import org.github.spring.restful.json.JSONReturn
import org.github.spring.restful.json.JSONPReturn
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/rest/")
class RestAction {
  @GetMapping("returnable")
  fun returnable(): String {
    return "index"
  }

  @RequestMapping("json")
  fun json() = JSON.nil()

  @RequestMapping("json/basic")
  fun jsonBasic() = JSONReturn.of()

  @RequestMapping("json/callback")
  fun jsonCallback(): Returnable = JSONPReturn.of()
}
