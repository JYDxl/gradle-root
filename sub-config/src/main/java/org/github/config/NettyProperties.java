package org.github.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("netty.config")
@Component
@Data
public class NettyProperties {
  /** port of netty. */
  private int    port   = 9002;
  /** server name of netty. */
  private String server = "netty-server";
  /** size of event loop group. */
  private int    size   = 24;
}
