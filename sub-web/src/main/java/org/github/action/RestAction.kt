package org.github.action

import org.github.spring.restful.Returnable
import org.github.spring.restful.json.JSON
import org.github.spring.restful.json.JSONBasic
import org.github.spring.restful.json.JSONP
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rest/")
class RestAction {
  @RequestMapping("returnable")
  fun returnable() = Returnable.nil()

  @RequestMapping("json")
  fun json() = JSON.nil()

  @RequestMapping("json/basic")
  fun jsonBasic() = JSONBasic.of()

  @RequestMapping("json/callback")
  fun jsonCallback(): Returnable = JSONP.of()
}
