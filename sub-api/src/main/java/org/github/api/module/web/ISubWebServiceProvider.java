package org.github.api.module.web;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "sub-web", fallback = SubWebServiceProviderFallback.class)
public interface ISubWebServiceProvider {}
