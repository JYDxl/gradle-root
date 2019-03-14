package org.github.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("netty.config")
@Component
@Data
public class NettyProperties {
  /** port of netty nio. */
  private int    nioPort   = 9002;
  /** server name of netty nio. */
  private String nioServer = "Netty-nio";
  /** size of event loop group. */
  private int    size      = 16;
}
