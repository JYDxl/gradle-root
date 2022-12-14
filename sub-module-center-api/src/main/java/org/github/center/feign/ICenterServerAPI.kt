package org.github.center.feign

import org.github.core.spring.restful.json.JSONArrayReturn
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient("center-server")
interface ICenterServerAPI {
    @PostMapping("/auth/permissionList")
    fun permissionList(@RequestHeader token: String): JSONArrayReturn<String>

    @PostMapping("/auth/roleList")
    fun roleList(@RequestHeader token: String): JSONArrayReturn<String>
}
