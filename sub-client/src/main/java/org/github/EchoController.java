package org.github;

import org.apache.dubbo.config.annotation.DubboReference;
import org.github.dubbo.web.IEchoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {
    @DubboReference
    private IEchoService echoService;

    @GetMapping("/echo")
    public String echo(String message) throws Exception {
        return echoService.echo(message);
    }
}
