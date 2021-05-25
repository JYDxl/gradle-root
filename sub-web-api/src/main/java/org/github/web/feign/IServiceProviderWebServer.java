package org.github.web.feign;

import org.github.spring.restful.json.JSONReturn;
import org.github.web.feign.fallback.ServiceProviderWebServerFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import static org.github.constant.Constants.SERVICE_PROVIDER_WEB_SERVER;

@FeignClient(value = SERVICE_PROVIDER_WEB_SERVER, fallback = ServiceProviderWebServerFallback.class)
public interface IServiceProviderWebServer {
  @GetMapping("/rest/json/basic")
  JSONReturn basic();
}
