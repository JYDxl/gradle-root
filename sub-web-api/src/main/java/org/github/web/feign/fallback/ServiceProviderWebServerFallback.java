package org.github.web.feign.fallback;

import org.github.spring.restful.json.JSONReturn;
import org.github.web.feign.IServiceProviderWebServer;

public class ServiceProviderWebServerFallback implements IServiceProviderWebServer {
    @Override
    public JSONReturn basic() {
        return JSONReturn.error();
    }
}
