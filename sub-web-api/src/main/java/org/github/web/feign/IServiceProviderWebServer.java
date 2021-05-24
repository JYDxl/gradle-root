package org.github.web.feign;

import org.github.spring.restful.json.JSONReturn;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;

import static org.github.constant.Constants.SERVICE_PROVIDER_WEB_SERVER;

@FeignClient(SERVICE_PROVIDER_WEB_SERVER)
@Primary
public interface IServiceProviderWebServer {
    @GetMapping("/rest/json/basic")
    JSONReturn basic();
}
