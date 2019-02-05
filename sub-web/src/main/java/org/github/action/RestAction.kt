package org.github.action

import org.github.spring.restful.Returnable
import org.github.spring.restful.json.JSON
import org.github.spring.restful.json.JSONBasic
import org.github.spring.restful.json.JSONP
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/rest/")
class RestAction {
  @RequestMapping("returnable")
  fun returnable() = Returnable { null }

  @RequestMapping("json")
  fun json() = JSON { null }

  @RequestMapping("json/basic")
  fun jsonBasic() = JSONBasic.of()

  @RequestMapping("json/callback")
  fun jsonCallback(): Returnable = JSONP.of()
}
