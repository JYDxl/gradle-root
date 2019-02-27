package org.github.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("netty.port")
@Component
@Data
public class NettyPortProperties {
  /** port of netty epoll. */
  private int epoll = 8081;
  /** port of netty   nio. */
  private int nio   = 8082;
}
