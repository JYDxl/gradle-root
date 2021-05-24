package org.github.web.feign;

import org.springframework.cloud.openfeign.FeignClient;

import static org.github.web.constant.Constants.SERVICE_PROVIDER_WEB_SERVER;

@FeignClient(name = SERVICE_PROVIDER_WEB_SERVER, fallback = SubWebServiceProviderFallback.class)
public interface ISubWebServiceProvider {}
