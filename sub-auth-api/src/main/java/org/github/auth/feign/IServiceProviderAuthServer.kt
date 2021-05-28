package org.github.auth.feign;

import org.github.auth.shiro.model.UserDTO;
import org.github.shiro.AuthorInfo;
import org.github.spring.restful.json.JSONDataReturn;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.github.constant.Constants.SERVICE_PROVIDER_AUTH_SERVER;

@FeignClient(value = SERVICE_PROVIDER_AUTH_SERVER)
public interface IServiceProviderAuthServer {
    @GetMapping("/security/user/{username}")
    JSONDataReturn<UserDTO> user(@RequestParam("token") String token, @RequestHeader("Token") String jwt, @PathVariable("username") String username);

    @GetMapping("/security/auth/{userId}")
    JSONDataReturn<List<AuthorInfo>> auth(@RequestParam("token") String token, @RequestHeader("Token") String jwt, @PathVariable("userId") String userId);
}
