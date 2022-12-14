package org.github.web.feign

import org.springframework.cloud.openfeign.FeignClient

@FeignClient("web-server")
interface IWebServerAPI
