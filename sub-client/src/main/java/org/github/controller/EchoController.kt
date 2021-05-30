package org.github.controller

import org.springframework.beans.factory.annotation.Autowired
import org.github.web.feign.IServiceProviderWebServer
import org.github.service.ISystemService
import org.springframework.web.bind.annotation.GetMapping
import org.github.spring.restful.json.JSONReturn
import org.springframework.web.bind.annotation.RestController

// import org.apache.dubbo.config.annotation.DubboReference;
// import org.github.web.dubbo.IEchoService;
@RestController
class EchoController {
  // @DubboReference
  // private IEchoService echoService;
  @Autowired
  private lateinit var webServer: IServiceProviderWebServer

  @Autowired
  private lateinit var systemService: ISystemService

  // @GetMapping("/echo")
  // public String echo(String message) throws Exception {
  //     return echoService.echo(message);
  // }
  @GetMapping("/basic")
  fun basic(): JSONReturn {
    val (token, jwt) = requireNotNull(systemService.feign().data)
    return webServer.basic(token, jwt)
  }
}
