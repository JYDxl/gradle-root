package org.github.web.feign.fallback;

import org.github.spring.restful.json.JSONReturn;
import org.github.web.feign.IServiceProviderWebServer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@ConditionalOnClass(FeignClient.class)
@Component
public class ServiceProviderWebServerFallback implements IServiceProviderWebServer {
    @Override
    public JSONReturn basic() {
        return JSONReturn.error();
    }
}
