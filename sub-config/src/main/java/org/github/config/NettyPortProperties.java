package org.github.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

@ConfigurationProperties("netty.port")
@Component
@Data
public class NettyPortProperties {
    /** port of netty epoll. */
    private int epoll = 8081;

    /** port of netty   nio. */
    private int nio = 8082;
}
