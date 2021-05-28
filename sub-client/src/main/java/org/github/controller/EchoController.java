package org.github.controller;

// import org.apache.dubbo.config.annotation.DubboReference;

import lombok.*;
import org.github.service.ISystemService;
import org.github.spring.restful.json.JSONReturn;
// import org.github.web.dubbo.IEchoService;
import org.github.web.feign.IServiceProviderWebServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {
  // @DubboReference
  // private IEchoService echoService;
  @Autowired
  private IServiceProviderWebServer webServer;
  @Autowired
  private ISystemService            systemService;

  // @GetMapping("/echo")
  // public String echo(String message) throws Exception {
  //     return echoService.echo(message);
  // }

  @GetMapping("/basic")
  public JSONReturn basic() {
    val feign = systemService.feign();
    return webServer.basic(feign.getFirst(), feign.getSecond());
  }
}
