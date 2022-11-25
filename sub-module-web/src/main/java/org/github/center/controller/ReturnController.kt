package org.github.center.controller

import org.github.ops.info
import org.github.ops.log
import org.github.spring.ops.appCtx
import org.github.spring.ops.ktGetResources
import org.github.spring.restful.Returnable
import org.github.spring.restful.file.FILE
import org.github.spring.restful.json.JSON
import org.github.spring.restful.json.JSONPReturn
import org.github.spring.restful.json.JSONReturn
import org.github.spring.restful.view.VIEW
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rest/")
class ReturnController {
  private val log = ReturnController::class.log

  @GetMapping("returnable")
  fun returnable(): Returnable {
//    val returnable = Returnable.nil()
//    val returnable = Returnable.of()
//    val returnable = Returnable.of("2333")
//    val returnable = Returnable {null}
    val returnable = Returnable {"2333"}
    log.info {returnable.toString()}
    log.info {returnable.get()}
    return returnable
  }

  @GetMapping("view")
  fun view(): Returnable {
//    val view = VIEW.of()
//    val view = VIEW.of("index")
    val view = VIEW {"index"}
    log.info {view.toString()}
    log.info {view.get()}
    return view
  }

  @GetMapping("file")
  fun file(): Returnable {
    val resource = appCtx.ktGetResources("classpath*:spy.properties").first()
    return FILE.of(resource)
  }

  @GetMapping("json")
  fun json(): Returnable {
//    val json = JSON.of()
//    val json = JSON.of(Pair(1, 2))
//    val json = JSON.of("{\n  \"name\": \"bob\",\n  \"age\": 13\n}")
//    val json = JSON.nil()
//    val json = JSON {null}
    val json = JSON {"{\n  \"name\": \"bob\",\n  \"age\": 12\n}"}
    log.info {json.toString()}
    log.info {json.get()}
    return json
  }

  @GetMapping("jsonp")
  fun jsonpReturn(): Returnable {
    val jsonp = JSONPReturn<Any?>()
    log.info {jsonp.toString()}
    log.info {jsonp.get()}
    return jsonp
  }

  @GetMapping("json/basic")
  fun jsonBasic() = JSONReturn()

  @GetMapping("json/callback")
  fun jsonCallback() = JSONPReturn<Any?>()
}
