package org.github.web.feign;

import org.github.spring.restful.json.JSONReturn;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import static org.github.constant.Constants.SERVICE_PROVIDER_WEB_SERVER;

@FeignClient(value = SERVICE_PROVIDER_WEB_SERVER)
public interface IServiceProviderWebServer {
  @GetMapping("/rest/json/basic")
  JSONReturn basic(@RequestParam("token") String token, @RequestHeader("Token") String jwt);
}
