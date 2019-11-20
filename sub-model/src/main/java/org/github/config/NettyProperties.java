package org.github.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("netty.config")
@Component
@Data
public class NettyProperties implements ConfigProperties {
  /** port of netty. */
  private int port = 10000;
  /** size of event loop group. */
  private int size = 0;
}
