package org.github.controller

import org.apache.shiro.authz.annotation.Logical.OR
import org.apache.shiro.authz.annotation.RequiresRoles
import org.github.ops.info
import org.github.ops.log
import org.github.spring.restful.Returnable
import org.github.spring.restful.file.FILE
import org.github.spring.restful.json.JSON
import org.github.spring.restful.json.JSONPReturn
import org.github.spring.restful.json.JSONReturn
import org.github.spring.restful.view.VIEW
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.io.File

@Controller
@RequestMapping("/rest/")
class RestController {
  private val log = RestController::class.log

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
  fun view(): VIEW {
//    val view = VIEW.of()
//    val view = VIEW.of("index")
    val view = VIEW {"index"}
    log.info {view.toString()}
    log.info {view.get()}
    return view
  }

  @GetMapping("file")
  fun file(): FILE {
    val file = FILE.of(File("Dockerfile"))
//    val file = FILE.of("test", FileInputStream(File("Dockerfile")))
//    val file = FILE {"Dockerfile"}
    log.info {file.toString()}
    log.info {file.get()}
    return file
  }

  @GetMapping("json")
  fun json(): JSON {
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
  fun jsonpReturn(): JSONPReturn<*> {
    val jsonp: JSONPReturn<Any?> = JSONPReturn.empty<Any?>()
    log.info {jsonp.toString()}
    log.info {jsonp.get()}
    return jsonp
  }

  @RequiresRoles("test", "admin", logical = OR)
  @GetMapping("json/basic")
  fun jsonBasic() = JSONReturn.of()

  @GetMapping("json/callback")
  fun jsonCallback(): Returnable = JSONPReturn.of()
}
