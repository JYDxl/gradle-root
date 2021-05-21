package org.github.feign.web;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "web-server", fallback = SubWebServiceProviderFallback.class)
public interface ISubWebServiceProvider {}
